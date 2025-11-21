import {Valoraciones} from '@core/models/valoraciones';

export interface Pedido {

  cuponAplicado: string;
  precioTotal: number;
  qr: string;
  estado: string;
  eliminado: string;
  idValoracion: Valoraciones;
}
