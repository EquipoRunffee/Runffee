import {Cafeteria} from '@core/models/cafeteria';

export class CafeteriaDetalles {
  constructor(
    public nombre: string = '',
    public imagen: string = '',
    public tipoCafeteria: string = '',
    public valoracionMedia: number = 0,
  ) {}
}
