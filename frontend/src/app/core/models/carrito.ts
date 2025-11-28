import {ProductoCarrito} from '@core/models/producto-carrito';
import {ProductoSeleccion} from '@core/models/producto-seleccion';

export class Carrito {
  idCafeteria: number;
  idReto: number | null;
  nombreCupon: string | null;
  kmObjetivo: number | null;
  tiempoObjetivo: number | null;
  productosCarrito: ProductoCarrito[];

  constructor(idCafeteria: number, idReto: number | null, nombreCupon: string | null,
              kmObjetivo:number | null, tiempoObjetivo:number | null, productos: ProductoCarrito[]) {
    this.idCafeteria = idCafeteria;
    this.idReto = idReto;
    this.nombreCupon = nombreCupon;
    this.kmObjetivo = kmObjetivo;
    this.tiempoObjetivo = tiempoObjetivo;
    this.productosCarrito = productos;
  }
}
