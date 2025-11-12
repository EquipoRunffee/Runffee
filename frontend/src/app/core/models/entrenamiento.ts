import {Usuario} from '@core/models/usuario';
import {Pedido} from '@core/models/pedido';

export interface Entrenamiento {

  nombre: string;
  fechaInicio: Date;
  fechaFin: Date;
  urlMapa: string;
  descripcion: string;
  distancia: number;
  eliminado: number;
  idUsuario: Usuario;
  idPedido: Pedido;
}
