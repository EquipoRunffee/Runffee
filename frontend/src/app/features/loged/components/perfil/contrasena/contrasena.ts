import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { UsuarioService } from '@core/services/usuario/usuarioService';

@Component({
  selector: 'app-contrasena',
  imports: [RouterModule, FormsModule, CommonModule],
  templateUrl: './contrasena.html',
  styleUrls: ['./contrasena.css'],
  standalone: true,
})
export class Contrasena {

  contrasenaVieja: string = '';
  contrasenaNueva: string = '';
  contrasenaRepetir: string = '';

  mensajeExito: string = '';
  mensajeError: string = '';

  mostrarExito: boolean = false;
  mostrarError: boolean = false;

  constructor(private usuarioService: UsuarioService) {}

  actualizar() {

    this.mensajeExito = '';
    this.mensajeError = '';
    this.mostrarExito = false;
    this.mostrarError = false;

    if (this.contrasenaVieja.trim().length < 6) {
      this.mensajeError = 'Debes introducir tu contraseña actual.';
      this.mostrarError = true;
      return;
    }

    if (this.contrasenaNueva.trim().length < 6) {
      this.mensajeError = 'Debes introducir una nueva contraseña válida.';
      this.mostrarError = true;
      return;
    }

    if (this.contrasenaVieja.trim() === this.contrasenaNueva.trim()) {
      this.mensajeError = 'Debes cambiar de contraseña.';
      this.mostrarError = true;
      return;
    }

    if (this.contrasenaNueva !== this.contrasenaRepetir) {
      this.mensajeError = 'Las nuevas contraseñas no coinciden.';
      this.mostrarError = true;
      return;
    }

    const datos = {
      contrasenaVieja: this.contrasenaVieja,
      contrasenaNueva: this.contrasenaNueva
    };

    this.usuarioService.setCambioContrasena(datos).subscribe({
      next: (res: string) => {
        this.mensajeExito = res; // mensaje del backend
        this.mostrarExito = true;
        this.mostrarError = false;

        this.contrasenaVieja = '';
        this.contrasenaNueva = '';
        this.contrasenaRepetir = '';
      },
      error: (err) => {
        if (err.status === 400 || err.status === 401) {
          this.mensajeError = "La contraseña actual es incorrecta.";
        } else if (err.status === 404) {
          this.mensajeError = "Usuario no encontrado.";
        } else {
          this.mensajeError = "Ha ocurrido un error inesperado.";
        }
        this.mostrarError = true;
        this.mostrarExito = false;
      }
    });
  }
}
