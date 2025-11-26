import {ProductoSeleccion} from '@core/models/producto-seleccion';

export class CafeteriaProductos {
   id: number;
   nombre: string;
   imagen: string;
   productos: ProductoSeleccion[];

  constructor(id: number, nombre: string, imagen: string, productos: ProductoSeleccion[]) {
    this.id = id;
    this.nombre = nombre;
    this.imagen = imagen;
    this.productos = productos;
  }
}
