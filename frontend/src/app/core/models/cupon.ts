import { Reto } from '@core/models/reto';

export class Cupon {
  constructor(
    public nombre: string = '',
    public fechaCaducidad: Date = new Date(),
    public tipo: string = '',
    public usado: string = 'no',
    public imagen: string = '',
    public porcentaje: number = 0,
    public descripcion: string = '',
    public eliminado: string = 'false',
    public idReto: Reto = new Reto()
  ) {}
}
