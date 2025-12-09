import { Component } from '@angular/core';
import {Router, RouterLink} from '@angular/router';
import {AuthService} from '@core/services/auth/auth-service';

@Component({
  selector: 'app-adminpage',
  standalone: true,
  templateUrl: './adminpage.html',
  styleUrl: './adminpage.css',
  imports: [
    RouterLink
  ]
})
export class Adminpage {
  constructor(private router: Router, private authService: AuthService) { }

  cerrarSesion(){
      this.authService.logout();
      this.router.navigate(['login']);
    }
}
