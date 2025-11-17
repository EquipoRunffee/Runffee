import { HttpInterceptorFn } from '@angular/common/http';
import {inject} from '@angular/core';
import {AuthService} from '@core/services/auth/auth-service';
import {catchError, switchMap, throwError} from 'rxjs';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
  const authService = inject(AuthService);
  const accessToken = authService.getAccessToken();

  if(accessToken){
    req = req.clone({
      setHeaders: {
        Authorization: `Bearer ${accessToken}`
      }
    })
  }

  return next(req).pipe(
    catchError((error) => {
      // Si el error es 401 y el mensaje indica token expirado
      if (error.status === 401 && error.error?.error === 'Token expirado') {
        const refreshToken = authService.getRefreshToken();
        if (!refreshToken) {
          // No hay refresh token, forzar logout
          authService.logout();
          return throwError(() => error);
        }

        // Llamar al endpoint de refresh
        return authService.renovarToken(refreshToken).pipe(
          switchMap((res: any) => {
            // Guardar nuevo accessToken
            authService.setAccessToken(res.accessToken);

            // Repetir la petición original con el nuevo token
            const clonedReq = req.clone({
              setHeaders: {
                Authorization: `Bearer ${res.accessToken}`
              }
            });
            return next(clonedReq);
          }),
          catchError((err) => {
            // Si falla el refresh, logout
            authService.logout();
            return throwError(() => err);
          })
        );
      }

      return throwError(() => error);
    })
  );
};
