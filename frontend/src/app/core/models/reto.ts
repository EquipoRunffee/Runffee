import {Entrenamiento} from '@core/models/entrenamiento';

export class Reto {
  constructor(
    public nombre: string = '',
    public descripcion: string = '',
    public fechaInicio: Date = new Date(),
    public fechaFin: Date = new Date(),
    public eliminado: string = 'false'
  ) {}
}
