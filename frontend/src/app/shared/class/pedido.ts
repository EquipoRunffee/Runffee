import {Valoracion} from '@shared/class/valoracion';

export interface Pedido {

  cuponAplicado: string;
  precioTotal: number;
  qr: string;
  estado: string;
  eliminado: string;
  idValoracion: Valoracion;
}
