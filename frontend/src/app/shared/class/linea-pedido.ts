import {Producto} from '@shared/class/producto';
import {Pedido} from '@shared/class/pedido';

export interface LineaPedido {

  cantidadProducto: number;
  eliminado: string;
  idProducto: Producto;
  idPedido: Pedido;
}
