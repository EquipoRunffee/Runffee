import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';


@Component({
  selector: 'app-register',
  templateUrl: './register.html',
  styleUrl: './register.css',
  standalone: true,
  imports: [
    FormsModule,

  ]
})
export class Register {

  usuario = {
    email: '',
    password: '',
    repeatpassword: ''
  };

  visible:boolean = false;

  ver(){
    this.visible=!this.visible;
  }

  register() {

    /*if (this.usuario.password.length < 8) {
      alert('La contraseña debe tener al menos 8 caracteres');
      return;
    }

    if (this.usuario.password !== this.usuario.repeatpassword) {
      alert('Las contraseñas no coinciden');
      return;
    }
    */
    console.log('Credenciales: ', this.usuario);
  }

}
