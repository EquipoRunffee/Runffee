import {Component} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {AdminService} from '@core/services/admin/adminService';
import {adminCafeteria} from '@core/models/adminCafeteria';

@Component({
  selector: 'app-controlcafeteria',
  standalone: true,
  templateUrl: './controlcafeteria.html',
  styleUrl: './controlcafeteria.css',
  imports: [
    FormsModule
  ]

})
export class Controlcafeteria{

// CAMPOS - CREAR CAFETERÍA
  crearNombre = '';
  crearDescripcion = '';
  crearLat: number | null = null;
  crearLng: number | null = null;
  crearImagen = '';
  crearTipoCafeteria = '';
  crearEliminado = 'false';

  // CAMPOS - MODIFICAR CAFETERÍA
  modificarId: number | null = null;
  nuevoNombre = '';
  nuevaDescripcion = '';
  nuevaLat: number | null = null;
  nuevaLng: number | null = null;
  nuevaImagen = '';
  nuevoTipoCafeteria = '';
  nuevoEliminado = 'false';

  // CAMPO - ELIMINAR CAFETERÍA
  eliminarId: number | null = null;

  constructor(private adminService: AdminService) {}

  //FUNCIÓN PARA CREAR CAFETERIA
  crearCafeteria() {

    if (!this.crearNombre.trim()) return alert('Introduce un nombre válido');
    if (!this.crearTipoCafeteria.trim()) return alert('Introduce un tipo de cafetería válido');
    if (this.crearLat === null || isNaN(this.crearLat)) return alert('Introduce una latitud válida');
    if (this.crearLng === null || isNaN(this.crearLng)) return alert('Introduce una longitud válida');

    const dto: adminCafeteria = new adminCafeteria(
      this.crearNombre.trim(),
      this.crearDescripcion.trim(),
      Number(this.crearLat),
      Number(this.crearLng),
      this.crearImagen.trim(),
      this.crearTipoCafeteria.trim(),
      this.crearEliminado === 'true'
    );

    this.adminService.crearCafeteria(dto).subscribe(
      () => {
        alert('Cafetería creada correctamente');
        this.limpiarCrear();
      },
      err => {
        console.error('Error al crear cafetería', err);
        alert('Error al crear cafetería. Revisa la consola.');
      }
    );
  }

  limpiarCrear() {
    this.crearNombre = '';
    this.crearDescripcion = '';
    this.crearLat = null;
    this.crearLng = null;
    this.crearImagen = '';
    this.crearTipoCafeteria = '';
    this.crearEliminado = 'false';
  }


  //FUNCIÓN PARA CARGAR LA CAFETERIA A MODIFICAR

  cargarDatos() {

    if (!this.modificarId || isNaN(this.modificarId)) {
      return alert('Introduce un ID válido');
    }

    this.adminService.obtenerCafeteria(this.modificarId).subscribe(
      (cafeteria: any) => {

        this.nuevoNombre = cafeteria.nombre;
        this.nuevaDescripcion = cafeteria.descripcion;
        this.nuevaLat = cafeteria.lat;
        this.nuevaLng = cafeteria.lng;
        this.nuevaImagen = cafeteria.imagen;
        this.nuevoTipoCafeteria = cafeteria.tipoCafeteria;
        this.nuevoEliminado = cafeteria.eliminado ? 'true' : 'false';

        console.log('Cafetería cargada:', cafeteria);
      },
      err => {
        console.error('Error al cargar cafetería', err);
        alert('Error al cargar cafetería. Revisa la consola.');
      }
    );
  }

  //FUNCIÓN PARA MODIFICAR

  modificarCafeteria() {

    if (!this.modificarId || isNaN(this.modificarId))
      return alert('Introduce un ID válido');

    if (this.nuevaLat === null || isNaN(this.nuevaLat))
      return alert('Introduce una latitud válida');

    if (this.nuevaLng === null || isNaN(this.nuevaLng))
      return alert('Introduce una longitud válida');

    const cafeteria = {
      nombre: this.nuevoNombre.trim(),
      descripcion: this.nuevaDescripcion.trim(),
      lat: Number(this.nuevaLat),
      lng: Number(this.nuevaLng),
      imagen: this.nuevaImagen.trim(),
      tipoCafeteria: this.nuevoTipoCafeteria.trim(),
      eliminado: this.nuevoEliminado === 'true'
    };

    this.adminService.modificarCafeteria(this.modificarId, cafeteria).subscribe(
      () => alert('Cafetería modificada correctamente'),
      err => {
        console.error('Error modificando cafetería', err);
        alert('Error modificando cafetería. Revisa la consola.');
      }
    );
  }

  //FUNCIÓN PARA ELIMINAR

  eliminarCafeteria() {

    if (!this.eliminarId) {
      return alert('Introduce un ID válido');
    }

    this.adminService.eliminarCafeteria(this.eliminarId).subscribe(
      () => {
        alert('Cafetería eliminada correctamente');
        this.eliminarId = null;
      },
      err => {
        console.error('Error eliminando cafetería', err);
        alert('Error al eliminar la cafetería');
      }
    );
  }

}
