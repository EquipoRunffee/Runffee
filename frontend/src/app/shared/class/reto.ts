import {Entrenamiento} from '@shared/class/entrenamiento';

export interface Reto {

  nombre: string;
  fechaInicio: Date;
  fechaCaducidad: Date;
  descripcion: string;
  eliminado: string;
  idEntrenamineto: Entrenamiento;
}
