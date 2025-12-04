import {Component} from '@angular/core';
import { AdminService } from "@core/services/admin/adminService";
import {adminProducto} from '@core/models/adminProducto';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-controlproducto',
  standalone: true,
  templateUrl: './controlproducto.html',
  styleUrl: './controlproducto.css',
  imports: [
    FormsModule
  ]
})
export class Controlproducto {

  //CAMPOS - CREAR PRODUCTO
  crearNombre = '';
  crearTipoProducto = '';
  crearImagen = '';
  crearPrecio: number | null = null;
  crearDescripcion = '';
  crearEliminado = 'false';
  crearIdCafeteria: number | null = null;

  //CAMPOS - MODIFICAR PRODUCTO
  modificarId: number | null = null;

  nuevoNombre = '';
  nuevoTipoProducto = '';
  nuevaImagen = '';
  nuevoPrecio: number | null = null;
  nuevaDescripcion = '';
  nuevoEliminado = 'false';
  nuevoIdCafeteria: number | null = null;

  //CAMPO - ELIMINAR PRODUCTO
  eliminarId: number | null = null;

  constructor(private adminService: AdminService) {}

  //FUNCIÓN PARA CREAR PRODUCTO
  crearProducto() {
    if (!this.crearNombre.trim()) return alert('Introduce un nombre válido');
    if (!this.crearTipoProducto.trim()) return alert('Introduce un tipo de producto válido');
    if (!this.crearIdCafeteria || isNaN(this.crearIdCafeteria))
      return alert('Introduce un ID de cafetería válido');

    const dto: adminProducto = new adminProducto(
      this.crearNombre.trim(),
      this.crearTipoProducto.trim(),
      this.crearImagen.trim(),
      Number(this.crearPrecio) || 0,
      this.crearDescripcion.trim(),
      this.crearEliminado === 'true',
      Number(this.crearIdCafeteria)
    );

    this.adminService.crearProducto(dto).subscribe(
      () => {
        alert('Producto creado correctamente');
        this.limpiarCrear();
      },
      err => {
        console.error('Error al crear producto', err);
        alert('Error al crear producto. Revisa la consola.');
      }
    );
  }

  limpiarCrear() {
    this.crearNombre = '';
    this.crearTipoProducto = '';
    this.crearImagen = '';
    this.crearPrecio = null;
    this.crearDescripcion = '';
    this.crearEliminado = 'false';
    this.crearIdCafeteria = null;
  }

  //FUNCIÓN PARA CARGAR EL PRODUCTO A MODIFICAR
  cargarDatos() {

    console.log(this.modificarId);

    if (!this.modificarId) {
      alert('Introduce un ID válido');
      return;
    }

    this.adminService.obtenerProducto(this.modificarId).subscribe(producto => {

      this.nuevoNombre = producto.nombre;
      this.nuevoTipoProducto = producto.tipoProducto;
      this.nuevaImagen = producto.imagen;
      this.nuevoPrecio = producto.precio;
      this.nuevaDescripcion = producto.descripcion;
      this.nuevoEliminado = producto.eliminado ? 'true' : 'false';
      this.nuevoIdCafeteria = producto.idCafeteria;

    }, () => {
      alert('No se pudo cargar el producto');
    });
  }

  //FUNCIÓN PARA MODIFICAR
  modificarProducto() {
    if (!this.modificarId || isNaN(this.modificarId)) return alert('Introduce un ID de producto válido');
    if (!this.nuevoIdCafeteria || isNaN(this.nuevoIdCafeteria)) return alert('Introduce un ID de cafetería válido');

    const dto = {
      nombre: this.nuevoNombre.trim(),
      tipoProducto: this.nuevoTipoProducto.trim(),
      imagen: this.nuevaImagen.trim(),
      precio: Number(this.nuevoPrecio) || 0,
      descripcion: this.nuevaDescripcion.trim(),
      eliminado: this.nuevoEliminado === 'true',
      idCafeteria: Number(this.nuevoIdCafeteria)
    };

    this.adminService.modificarProducto(this.modificarId, dto).subscribe(
      () => alert('Producto modificado correctamente'),
      err => {
        console.error('Error modificando producto', err);
        alert('Error modificando producto. Revisa la consola.');
      }
    );
  }

  //FUNCIÓN PARA ELIMINAR
  eliminarProducto() {

    if (!this.eliminarId) {
      alert('Introduce un ID válido');
      return;
    }

    this.adminService.eliminarProducto(this.eliminarId).subscribe(() => {
      alert('Producto eliminado correctamente');
      this.eliminarId = null;
    }, () => {
      alert('Error al eliminar el producto');
    });
  }
}
