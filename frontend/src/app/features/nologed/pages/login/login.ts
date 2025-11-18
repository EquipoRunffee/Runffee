import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {Router} from '@angular/router';
import {StravaService} from '@core/services/strava/stravaService';
import {AuthService} from '@core/services/auth/auth-service';

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
    correo: '',
    contrasena: ''
  };

  constructor(private router: Router, private stravaService: StravaService, private authService: AuthService) {
  }

  login() {
    console.log('Credenciales: ', this.usuario);
    this.authService.login({correo: this.usuario.correo, contrasena: this.usuario.contrasena}).subscribe({
      next: (res) => {
        this.router.navigate(['/app/perfil']);
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  /*
  * Importamos el Servicio Strava --> Llamamos a la función de conexionStrava (pincha en la función para ver lo que hace) -->
  * --> Se redirige al usuario a la pagina de Inicio de Sesión de Strava -->
  * --> Cuando se ha logueado/registrado --> Se le redirige al componente Exchange -->
  * --> Este recibe los tokens (la primera vez tarda bastante por lo que hay que poner un Loading) -->
  * --> Cuando recibamos los tokens y los datos del usuario hay que:
  *   - Comprobar que el "athlete_id" no esté en la bbdd porque eso significaría que el usuario ya estaba registrado en nuestra app
  *   - Si el "athlete_id" no se encuentra en nuestra bbdd --> Lo redirigimos a "Crear correo y contraseña"
  *   - Si se encuentra en la bbdd --> Lo redirigimos al Login
  * */

  conectarConStrava() {
    this.stravaService.conexionStrava();
  }
}
