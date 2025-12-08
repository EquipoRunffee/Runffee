import {Component, signal} from '@angular/core';
import { AdminService } from '@core/services/admin/adminService';
import { adminReto } from '@core/models/adminReto';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-controlreto',
  standalone: true,
  templateUrl: './controlreto.html',
  styleUrl: './controlreto.css',
  imports: [
    FormsModule
  ]
})
export class Controlreto {

// CAMPOS - CREAR RETO
  crearNombre = '';
  crearDescripcion = '';
  crearFechaInicio: string = '';
  crearFechaFin: string = '';
  crearEliminado = 'false';

// CAMPOS - MODIFICAR RETO
  modificarId: number | null = null;
  nuevoNombre = '';
  nuevaDescripcion = '';
  nuevaFechaInicio: string = '';
  nuevaFechaFin: string = '';
  nuevoEliminado = 'false';

// CAMPO - ELIMINAR RETO
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


// CREAR RETO
  crearReto() {
    if (!this.crearNombre.trim()) return this.mostrarMensaje('Introduce un nombre válido');
    if (!this.crearDescripcion.trim()) return this.mostrarMensaje('Introduce una descripción válida');

    const dto: adminReto = new adminReto(
      this.crearNombre.trim(),
      this.crearDescripcion.trim(),
      new Date(this.crearFechaInicio),
      new Date(this.crearFechaFin),
    this.crearEliminado === 'true'
    );

    this.adminService.crearReto(dto).subscribe(
      () => {
        this.mostrarMensaje('Reto creado correctamente');
        this.limpiarCrear();
      },
      err => {
        console.error('Error al crear reto', err);
        this.mostrarMensaje('Error al crear reto. Revisa la consola.');
      }
    );

  }

  limpiarCrear() {
    this.crearNombre = '';
    this.crearDescripcion = '';
    this.crearFechaInicio = '';
    this.crearFechaFin = '';
    this.crearEliminado = 'false';
  }

  // CARGAR RETO
  cargarDatos() {
    if (!this.modificarId || isNaN(this.modificarId)) {
      return this.mostrarMensaje('Introduce un ID válido');
    }

    this.adminService.obtenerReto(this.modificarId).subscribe(
      (reto: any) => {
        this.nuevoNombre = reto.nombre;
        this.nuevaDescripcion = reto.descripcion;
        this.nuevaFechaInicio = reto.fecha_inicio.toISOString().split('T')[0];
        this.nuevaFechaFin = reto.fecha_fin.toISOString().split('T')[0];
        this.nuevoEliminado = reto.eliminado ? 'true' : 'false';

        console.log('Reto cargado correctamente:', reto);
      },
      err => {
        console.error('Error al cargar reto', err);
        this.mostrarMensaje('Error al cargar reto. Revisa la consola.');
      }
    );

  }

  // MODIFICAR RETO
  modificarReto() {
    if (!this.modificarId || isNaN(this.modificarId)) return this.mostrarMensaje('Introduce un ID válido');
    if (!this.nuevoNombre.trim()) return this.mostrarMensaje('Introduce un nombre válido');
    if (!this.nuevaDescripcion.trim()) return this.mostrarMensaje('Introduce una descripción válida');
    if (!this.nuevaFechaInicio) return this.mostrarMensaje('Introduce una fecha de inicio válida');
    if (!this.nuevaFechaFin) return this.mostrarMensaje('Introduce una fecha de caducidad válida');

    const dto: adminReto = new adminReto(
      this.nuevoNombre.trim(),
      this.nuevaDescripcion.trim(),
      new Date(this.nuevaFechaInicio),
      new Date(this.nuevaFechaFin),
      this.nuevoEliminado === 'true'
    );

    this.adminService.modificarReto(this.modificarId, dto).subscribe(
      () => this.mostrarMensaje('Reto modificado correctamente'),
      err => {
        console.error('Error modificando reto', err);
        this.mostrarMensaje('Error modificando reto. Revisa la consola.');
      }
    );

  }

  // ELIMINAR RETO
  eliminarReto() {
    if (!this.eliminarId) {
      this.mostrarMensaje('Introduce un ID válido');
      return;
    }
    this.adminService.eliminarReto(this.eliminarId).subscribe(() => {
      this.mostrarMensaje('Reto eliminado correctamente');
        this.eliminarId = null;
      }, () => {
      this.mostrarMensaje('Error al eliminar reto. Revisa la consola.');
      }
    );

  }
}
