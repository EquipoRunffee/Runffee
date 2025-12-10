import { Component } from '@angular/core';
import {FormBuilder, FormsModule} from '@angular/forms';
import {AuthService} from '@core/services/auth/auth-service';
import {Router} from '@angular/router';
import {CommonModule, NgClass} from '@angular/common';


@Component({
  selector: 'app-register',
  templateUrl: './register.html',
  styleUrl: './register.css',
  standalone: true,
  imports: [FormsModule, NgClass, CommonModule]
})
export class Register {
  usuario = { correo: '', password: '', repeatpassword: '' };
  visible = false;
  formularioValido: boolean = false;

  mostrarOtpModal = false;
  otp = '';
  mensajeOtp = '';
  errorOtp = false;

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

  registrarUsuario(){
    this.passwordError = ''; this.repeatPasswordError = '';
    // Validación 1: Contraseña de mínimo 8 caracteres
    if (this.usuario.password.length < 6)
    { this.passwordError = 'La contraseña debe tener al menos 6 caracteres';}
    // Validación 2: Contraseñas coinciden
    if (this.usuario.password !== this.usuario.repeatpassword)
    { this.repeatPasswordError = 'Las contraseñas no coinciden';}

    if(this.usuario.password.length >= 6 && this.usuario.password == this.usuario.repeatpassword){
      this.formularioValido = true;
    }

    if(localStorage.getItem("stravaAccessToken") && this.formularioValido){
      this.authService.registrar(
        {correo: this.usuario.correo, contrasena: this.usuario.password, stravaAccessToken: localStorage.getItem("stravaAccessToken")})
        .subscribe({
          next: (res) => {
            this.mostrarOtpModal = true;
          },
          error: (err) => {
            console.log(err);
            this.correoError = 'El correo ya está registrado';
          }
        });
    } else {
      console.log("No se encuentra el token de Strava...");
    }
  }

  verificarOtp() {
    this.authService.verificarOtp({ correo: this.usuario.correo, otp: this.otp })
      .subscribe({
        next: (res: any) => {
          this.mensajeOtp = res.mensaje;
          this.errorOtp = false;
          setTimeout(() => {
            this.mostrarOtpModal = false;
            this.router.navigate(['/login']);
          }, 1500);
        },
        error: (err) => {
          this.mensajeOtp = err.error || 'OTP incorrecto';
          this.errorOtp = true;
        }
      });
  }
}
