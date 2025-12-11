import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {Router, RouterLink} from '@angular/router';
import {StravaService} from '@core/services/strava/stravaService';
import {AuthService} from '@core/services/auth/auth-service';

@Component({
  selector: 'app-login',
  templateUrl: './login.html',
  styleUrl: './login.css',
  imports: [
    FormsModule,
    RouterLink
  ]
})
export class Login {

  usuario = {
    correo: '',
    contrasena: ''
  };

  mostrarMensajesEstado:boolean = false;
  textoMensajes:string = "";
  mostrarLoader: boolean = false;

  constructor(private router: Router, private stravaService: StravaService, private authService: AuthService) {
  }

  login() {
    this.mostrarLoader = true;
    this.authService.login({correo: this.usuario.correo, contrasena: this.usuario.contrasena})
      .subscribe({
        next: () => {
          this.router.navigate(['/app']);
        },
        error: (err) => {
          console.log(err); // Ver lo que envía el backend
          this.mostrarLoader = false;
          // Mensaje por defecto
          let mensaje = "";

          // Capturar errores por status
          if (err.status === 500) {
            mensaje = "El usuario no existe";
          } else if (err.status === 401 || err.status === 403) {
            mensaje = "Correo o contraseña incorrecto";
          } else {
            mensaje = "Ha ocurrido un error inesperado.";
          }

          // Mostrar mensaje usando tu función
          this.mostrarMensajes(mensaje);

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

  mostrarMensajes(mensaje: string):void{
    this.mostrarMensajesEstado = true;
    this.textoMensajes = mensaje;
    setTimeout(() => {
      this.mostrarMensajesEstado = false;
    }, 3000)
  }
}
