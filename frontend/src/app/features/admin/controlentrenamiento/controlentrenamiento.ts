import {Component, signal} from '@angular/core';
import {FormsModule} from '@angular/forms';
import { AdminService } from '@core/services/admin/adminService';
import { adminEntrenamiento } from '@core/models/adminEntrenamiento';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-controlentrenamiento',
  standalone: true,
  templateUrl: './controlentrenamiento.html',
  styleUrl: './controlentrenamiento.css',
  imports: [FormsModule, RouterLink],
})
export class Controlentrenamiento {

// CAMPOS - MODIFICAR ENTRENAMIENTO
  modificarId: number | null = null;

  nuevoNombre = '';
  nuevaFechaInicio: string = '';
  nuevaFechaFin: string = '';
  nuevoKmObjetivo: number | null = null;
  nuevoTiempoObjetivo: number | null = null;
  nuevoCompletado = 'false';
  nuevoEliminado = 'false';

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

// CARGAR DATOS
  cargarDatos() {
    if (!this.modificarId || isNaN(this.modificarId)) {
      this.mostrarMensaje('Introduce un ID de entrenamiento válido');
      return;
    }

    this.adminService.obtenerEntrenamiento(this.modificarId).subscribe(
      (entrenamiento: adminEntrenamiento) => {
        this.nuevoNombre = entrenamiento.nombre;
        this.nuevaFechaInicio = new Date(entrenamiento.fecha_inicio).toISOString().slice(0,16);
        this.nuevaFechaFin = new Date(entrenamiento.fecha_fin).toISOString().slice(0,16);
        this.nuevoKmObjetivo = entrenamiento.kmObjetivo;
        this.nuevoTiempoObjetivo = entrenamiento.tiempoObjetivo;
        this.nuevoCompletado = entrenamiento.completado ? 'true' : 'false';
        this.nuevoEliminado = entrenamiento.eliminado ? 'true' : 'false';
      },
      err => {
        console.error('Error al cargar entrenamiento', err);
        this.mostrarMensaje('Error al cargar entrenamiento. Revisa la consola.');
      }
    );

  }

// MODIFICAR ENTRENAMIENTO
  modificarEntrenamiento() {
    if (!this.modificarId || isNaN(this.modificarId)) {
      this.mostrarMensaje('Introduce un ID de entrenamiento válido');
      return;
    }

    const dto = new adminEntrenamiento(
      this.nuevoNombre.trim(),
      new Date(this.nuevaFechaInicio),
      new Date(this.nuevaFechaFin),
      Number(this.nuevoKmObjetivo) || 0,
      Number(this.nuevoTiempoObjetivo) || 0,
      this.nuevoCompletado === 'true',
      this.nuevoEliminado === 'true'
    );

    this.adminService.modificarEntrenamiento(this.modificarId, dto).subscribe(
      () => this.mostrarMensaje('Entrenamiento modificado correctamente'),
      err => {
        console.error('Error modificando entrenamiento', err);
        this.mostrarMensaje('Error modificando entrenamiento. Revisa la consola.');
      }
    );

  }

}
