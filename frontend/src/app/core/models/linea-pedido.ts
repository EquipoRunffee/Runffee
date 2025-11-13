import {Producto} from '@core/models/producto';
import {Pedido} from '@core/models/pedido';

export interface LineaPedido {

  cantidadProducto: number;
  eliminado: string;
  idProducto: Producto;
  idPedido: Pedido;
}
