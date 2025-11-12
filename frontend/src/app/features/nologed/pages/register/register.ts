import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-register',
  templateUrl: './register.html',
  styleUrl: './register.css',
  standalone: true,
  imports: [CommonModule, FormsModule,]
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

  async register() {
    this.emailError = '';
    this.passwordError = '';
    this.repeatPasswordError = '';

    // Validaciones básicas
    if (this.usuario.password.length < 8) {
      this.passwordError = 'La contraseña debe tener al menos 8 caracteres';
      return;
    }
    if (this.usuario.password !== this.usuario.repeatpassword) {
      this.repeatPasswordError = 'Las contraseñas no coinciden';
      return;
    }

    // Validación asíncrona: comprobar si el correo ya existe
    const emailExists = await this.checkEmailExists(this.usuario.email);
    if (emailExists) {
      this.emailError = 'El correo ya está registrado.';
      return;
    }

    console.log('Registro válido:', this.usuario);
    // Aquí haces la petición POST para registrar al usuario
  }

  // Simulación de consulta a la base de datos
  async checkEmailExists(email: string): Promise<boolean> {
    // ⚠️ Sustituye este método por tu llamada real al backend con HttpClient
    const existingEmails = ['test@example.com', 'demo@gmail.com'];
    return new Promise(resolve => {
      setTimeout(() => resolve(existingEmails.includes(email)), 1000);
    });
  }
}
