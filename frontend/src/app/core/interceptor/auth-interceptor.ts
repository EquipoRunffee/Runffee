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
      router.navigate(['/login']);
      return throwError(() => {
        error;
        router.navigate(['/login']);
      });
    })
  );
};
