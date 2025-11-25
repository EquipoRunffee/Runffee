import {Observable} from 'rxjs';
import {ProductoCarrito} from '@core/models/producto-carrito';

export class CafeteriaProductos {
   id: number;
   nombre: string;
   imagen: string;
   productos: ProductoCarrito[];

  constructor(id: number, nombre: string, imagen: string, productos: ProductoCarrito[]) {
    this.id = id;
    this.nombre = nombre;
    this.imagen = imagen;
    this.productos = productos;
  }
}
