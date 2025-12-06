import {Component, signal} from '@angular/core';
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
  crearDescripcion = '';
  crearEliminado = 'false';
  crearIdCafeteria: number | null = null;
  crearImagen = '';
  crearNombre = '';
  crearPrecio: number | null = null;
  crearTipoProducto = '';

  //CAMPOS - MODIFICAR PRODUCTO
  modificarId: number | null = null;

  nuevaDescripcion = '';
  nuevoEliminado = 'false';
  nuevoIdCafeteria: number | null = null;
  nuevaImagen = '';
  nuevoNombre = '';
  nuevoPrecio: number | null = null;
  nuevoTipoProducto = '';

  //CAMPO - ELIMINAR PRODUCTO
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

  //FUNCIÓN PARA CREAR PRODUCTO
  crearProducto() {
    if (!this.crearNombre.trim()) return this.mostrarMensaje('Introduce un nombre válido');
    if (!this.crearTipoProducto.trim()) return this.mostrarMensaje('Introduce un tipo de producto válido');
    if (!this.crearIdCafeteria || isNaN(this.crearIdCafeteria))
      return this.mostrarMensaje('Introduce un ID de cafetería válido');

    const dto: adminProducto = new adminProducto(
      this.crearDescripcion.trim(),
      this.crearEliminado === 'true',
      Number(this.crearIdCafeteria),
      this.crearImagen.trim(),
      this.crearNombre.trim(),
      Number(this.crearPrecio) || 0,
      this.crearTipoProducto.trim()
    );

    this.adminService.crearProducto(dto).subscribe(
      () => {
        this.mostrarMensaje('Producto creado correctamente');
        this.limpiarCrear();
      },
      err => {
        console.error('Error al crear producto', err);
        this.mostrarMensaje('Error al crear producto. Revisa la consola.');
      }
    );
  }

  limpiarCrear() {
    this.crearDescripcion = '';
    this.crearEliminado = 'false';
    this.crearIdCafeteria = null;
    this.crearImagen = '';
    this.crearNombre = '';
    this.crearPrecio = null;
    this.crearTipoProducto = '';
  }

  //FUNCIÓN PARA CARGAR EL PRODUCTO A MODIFICAR
  cargarDatos() {

    if (!this.modificarId || isNaN(this.modificarId)) {
      return this.mostrarMensaje('Introduce un ID de producto válido');
    }

    this.adminService.obtenerProducto(this.modificarId).subscribe(
      (producto: any) => {

        this.nuevaDescripcion = producto.descripcion;
        this.nuevoEliminado = producto.eliminado ? 'true' : 'false';
        this.nuevoIdCafeteria = producto.idCafeteria;
        this.nuevaImagen = producto.imagen;
        this.nuevoNombre = producto.nombre;
        this.nuevoPrecio = producto.precio;
        this.nuevoTipoProducto = producto.tipoProducto;

        console.log('Producto cargado correctamente:', producto);
      },
      err => {
        console.error('Error al cargar producto', err);
        this.mostrarMensaje('Error al cargar producto. Revisa la consola.');
      }
    );
  }

  //FUNCIÓN PARA MODIFICAR
  modificarProducto() {
    if (!this.modificarId || isNaN(this.modificarId)) return this.mostrarMensaje('Introduce un ID de producto válido');
    if (!this.nuevoIdCafeteria || isNaN(this.nuevoIdCafeteria)) return this.mostrarMensaje('Introduce un ID de cafetería válido');

    const dto = {
      descripcion: this.nuevaDescripcion.trim(),
      eliminado: this.nuevoEliminado === 'false',
      idCafeteria: Number(this.nuevoIdCafeteria),
      imagen: this.nuevaImagen.trim(),
      nombre: this.nuevoNombre.trim(),
      precio: Number(this.nuevoPrecio) || 0,
      tipoProducto: this.nuevoTipoProducto.trim(),
    };

    this.adminService.modificarProducto(this.modificarId, dto).subscribe(
      () => this.mostrarMensaje('Producto modificado correctamente'),
      err => {
        console.error('Error modificando producto', err);
        this.mostrarMensaje('Error modificando producto. Revisa la consola.');
      }
    );
  }

  //FUNCIÓN PARA ELIMINAR
  eliminarProducto() {

    if (!this.eliminarId) {
      this.mostrarMensaje('Introduce un ID válido');
      return;
    }

    this.adminService.eliminarProducto(this.eliminarId).subscribe(() => {
      this.mostrarMensaje('Producto eliminado correctamente');
      this.eliminarId = null;
    }, () => {
      this.mostrarMensaje('Error al eliminar el producto');
    });
  }
}
