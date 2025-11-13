import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-register',
  templateUrl: './register.html',
  styleUrl: './register.css',
  standalone: true,
  imports: [FormsModule,]
})
export class Register {
  usuario = { email: '', password: '', repeatpassword: '' };
  visible = false;

  emailError = '';
  passwordError = '';
  repeatPasswordError = '';

  ver() {
    this.visible = !this.visible;
  }


//metodo cuando compruebe que el correo ya está registrado
 setEmailError()
 { this.emailError = 'El correo ya está registrado.';
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
}

