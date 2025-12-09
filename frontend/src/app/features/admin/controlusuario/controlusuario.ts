import { Component, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AdminService } from "@core/services/admin/adminService";
import {adminUsuario} from '@core/models/adminUsuario';
import {RouterLink} from '@angular/router';


@Component({
  selector: 'app-controlusuario',
  standalone: true,
  templateUrl: './controlusuario.html',
  styleUrls: ['./controlusuario.css'],
  imports: [FormsModule, RouterLink]
})
export class Controlusuario {

  // CAMPOS - MODIFICAR USUARIO
  modificarId: number | null = null;

  nuevoCorreo = '';
  nuevaContrasena = '';
  nuevoRol = '';

  // CAMPOS - ELIMINAR USUARIO
  eliminarId: number | null = null;

  // POPUP
  mostrarPopUp = signal(false);
  textoPopUp = signal('');

  constructor(private adminService: AdminService) {}

  // FUNCION PARA MOSTRAR MENSAJES EN POPUP
  mostrarMensaje(mensaje: string) {
    this.textoPopUp.set(mensaje);
    this.mostrarPopUp.set(true);

    setTimeout(() => {
      this.mostrarPopUp.set(false);
    }, 3000);
  }

  // FUNCIÓN PARA CARGAR DATOS DEL USUARIO
  cargarDatos() {
    if (!this.modificarId || isNaN(this.modificarId)) {
      return this.mostrarMensaje('Introduce un ID de usuario válido');
    }

    this.adminService.obtenerUsuario(this.modificarId).subscribe(
      (usuario: adminUsuario) => {
        this.nuevoCorreo = usuario.correo || '';
        this.nuevaContrasena = usuario.contrasena || '';
        this.nuevoRol = usuario.rol || '';
      },
      err => {
        console.error('Error al cargar usuario', err);
        this.mostrarMensaje('Error al cargar usuario. Revisa la consola.');
      }
    );
  }

  // FUNCIÓN PARA MODIFICAR USUARIO
  modificarUsuario() {
    if (!this.modificarId || isNaN(this.modificarId)) {
      return this.mostrarMensaje('Introduce un ID de usuario válido');
    }

    const dto: adminUsuario = {
      correo: this.nuevoCorreo.trim(),
      contrasena: this.nuevaContrasena.trim(),
      rol: this.nuevoRol!,
      eliminado: false
    };

    this.adminService.modificarUsuario(this.modificarId, dto).subscribe(
      () => {
        this.mostrarMensaje('Usuario modificado correctamente');
        this.limpiarModificar();
      },
      err => {
        console.error('Error modificando usuario', err);
        this.mostrarMensaje('Error modificando usuario. Revisa la consola.');
      }
    );
  }

  // FUNCIÓN PARA LIMPIAR CAMPOS
  limpiarModificar() {
    this.modificarId = null;
    this.nuevoCorreo = '';
    this.nuevaContrasena = '';
    this.nuevoRol = '';
  }

  // FUNCIÓN PARA ELIMINAR USUARIO
  eliminarUsuario() {
    if (!this.eliminarId || isNaN(this.eliminarId)) return this.mostrarMensaje('Introduce un ID válido');

    this.adminService.eliminarUsuario(this.eliminarId).subscribe(
      () => {
        this.mostrarMensaje('Usuario eliminado correctamente');
        this.eliminarId = null;
      },
      err => {
        console.error('Error al eliminar usuario', err);
        this.mostrarMensaje('Error al eliminar usuario. Revisa la consola.');
      }
    );
  }
}
