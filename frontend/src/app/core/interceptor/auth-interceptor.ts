import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { AuthService } from '@core/services/auth/auth-service';
import { Router } from '@angular/router';
import { catchError, throwError } from 'rxjs';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
  const authService = inject(AuthService);
  const router = inject(Router);
  const accessToken = authService.getAccessToken();

  if (accessToken) {
    req = req.clone({
      setHeaders: {
        Authorization: `Bearer ${accessToken}`
      }
    });
  } else {
    router.navigate(['/login']);
  }

  return next(req).pipe(
    catchError(error => {

      // ✔ Si el error es de tipo 400–499 → redirigir al login
      if (error.status >= 400 && error.status < 500) {
        console.warn('Error 4xx detectado. Redirigiendo al login...', error);
        router.navigate(['/login']);
      }

      return throwError(() => error);
    })
  );
};
