import { Component } from '@angular/core';
import { AdminService } from '@core/services/admin/adminService';
import { adminReto } from '@core/models/adminReto';
import { FormsModule } from '@angular/forms';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-controlreto',
  standalone: true,
  templateUrl: './controlreto.html',
  styleUrl: './controlreto.css',
  imports: [
    FormsModule,
    RouterLink
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

  constructor(private adminService: AdminService) {}

// CREAR RETO
  crearReto() {
    if (!this.crearNombre.trim()) return alert('Introduce un nombre válido');
    if (!this.crearDescripcion.trim()) return alert('Introduce una descripción válida');

    const dto: adminReto = new adminReto(
      this.crearNombre.trim(),
      this.crearDescripcion.trim(),
      new Date(this.crearFechaInicio),
      new Date(this.crearFechaFin),
    this.crearEliminado === 'true'
    );

    this.adminService.crearReto(dto).subscribe(
      () => {
        alert('Reto creado correctamente');
        this.limpiarCrear();
      },
      err => {
        console.error('Error al crear reto', err);
        alert('Error al crear reto. Revisa la consola.');
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
      return alert('Introduce un ID válido');
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
        alert('Error al cargar reto. Revisa la consola.');
      }
    );

  }

  // MODIFICAR RETO
  modificarReto() {
    if (!this.modificarId || isNaN(this.modificarId)) return alert('Introduce un ID válido');
    if (!this.nuevoNombre.trim()) return alert('Introduce un nombre válido');
    if (!this.nuevaDescripcion.trim()) return alert('Introduce una descripción válida');
    if (!this.nuevaFechaInicio) return alert('Introduce una fecha de inicio válida');
    if (!this.nuevaFechaFin) return alert('Introduce una fecha de caducidad válida');

    const dto: adminReto = new adminReto(
      this.nuevoNombre.trim(),
      this.nuevaDescripcion.trim(),
      new Date(this.nuevaFechaInicio),
      new Date(this.nuevaFechaFin),
      this.nuevoEliminado === 'true'
    );

    this.adminService.modificarReto(this.modificarId, dto).subscribe(
      () => alert('Reto modificado correctamente'),
      err => {
        console.error('Error modificando reto', err);
        alert('Error modificando reto. Revisa la consola.');
      }
    );

  }

  // ELIMINAR RETO
  eliminarReto() {
    if (!this.eliminarId) {
      alert('Introduce un ID válido');
      return;
    }
    this.adminService.eliminarReto(this.eliminarId).subscribe(() => {
        alert('Reto eliminado correctamente');
        this.eliminarId = null;
      }, () => {
        alert('Error al eliminar reto. Revisa la consola.');
      }
    );

  }
}
