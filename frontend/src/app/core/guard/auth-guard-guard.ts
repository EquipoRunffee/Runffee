import {CanActivateFn, Router} from '@angular/router';
import {inject} from '@angular/core';
import {AuthService} from '@core/services/auth/auth-service';

export const authGuardGuard: CanActivateFn = (route, state) => {
  const authService = inject(AuthService);
  const router = inject(Router);

  if (authService.isLogged()) {
    return true;
  } else {
    router.navigate(['/login']);
    return false;
  }
};
