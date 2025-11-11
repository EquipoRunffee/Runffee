import {Reto} from '@shared/class/reto';

export interface Cupon {
  nombre: string;
  fechaCaducidad: Date;
  tipo: string;
  usado: string;
  imagen: string;
  porcentaje: number;
  descripcion: string;
  eliminado: string;
  idReto: Reto;
}
