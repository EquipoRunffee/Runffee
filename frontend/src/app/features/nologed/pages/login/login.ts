    import { Component } from '@angular/core';
    import {FormsModule} from '@angular/forms';
    import {Router} from '@angular/router';
    import {StravaService} from '@core/services/strava/stravaService';

@Component({
  selector: 'app-login',
  templateUrl: './login.html',
  styleUrl: './login.css',
  imports: [
    FormsModule
  ]
})
export class Login {

  usuario = {
    email: '',
    password: ''
  };

  login() {
    console.log('Credenciales: ', this.usuario);
  }

  constructor(private router: Router, private stravaService: StravaService) {
  }

  conectarConStrava() {
    this.stravaService.conexionStrava();
  }
}
