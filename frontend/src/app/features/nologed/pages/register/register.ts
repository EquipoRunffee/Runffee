import { Component } from '@angular/core';
import {FormBuilder, FormsModule} from '@angular/forms';
import {AuthService} from '@core/services/auth/auth-service';
import {Router} from '@angular/router';


@Component({
  selector: 'app-register',
  templateUrl: './register.html',
  styleUrl: './register.css',
  standalone: true,
  imports: [FormsModule]
})
export class Register {
  usuario = { correo: '', password: '', repeatpassword: '' };
  visible = false;

  correoError = '';
  passwordError = '';
  repeatPasswordError = '';


  constructor(private authService: AuthService, private router: Router) {}


  ver() {
    this.visible = !this.visible;
  }


//metodo cuando compruebe que el correo ya está registrado
 setcorreoError() {
   this.correoError = 'El correo ya está registrado.';
 }



 register() {
    // Limpiar mensajes previos (excepto si ya se mostró un error de correo)
   this.passwordError = ''; this.repeatPasswordError = '';
   let valid = true;
   // Validación 1: Contraseña de mínimo 8 caracteres
   if (this.usuario.password.length < 8)
   { this.passwordError = 'La contraseña debe tener al menos 8 caracteres';
     valid = false;
   }
   // Validación 2: Contraseñas coinciden
   if (this.usuario.password !== this.usuario.repeatpassword)
   { this.repeatPasswordError = 'Las contraseñas no coinciden';
     valid = false;
   }
   if (valid){ console.log('Credenciales: ', this.usuario);
   }
  }

  registrarUsuario(){
    if(localStorage.getItem("stravaAccessToken")){
      this.authService.registrar(
        {correo: this.usuario.correo, contrasena: this.usuario.password, stravaAccessToken: localStorage.getItem("stravaAccessToken")})
        .subscribe({
          next: (res) => {
            this.router.navigate(['/app']);
          },
          error: (err) => {
            console.log(err);
          }
        });
    } else {
      console.log("No se encuentra el token de Strava...");
    }
  }
}

