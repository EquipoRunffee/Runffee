import {ProductoCarrito} from '@core/models/producto-carrito';

export class Carrito {
  idProducto: number;
  productoCarrito: ProductoCarrito[];

  constructor(idProducto: number, productoCarrito: ProductoCarrito[]) {
    this.idProducto = idProducto;
    this.productoCarrito = productoCarrito;
  }
}
