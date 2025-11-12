import {Usuario} from '@shared/class/usuario';
import {Pedido} from '@shared/class/pedido';

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
