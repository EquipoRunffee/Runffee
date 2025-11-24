export class CafeteriaDetalles {
  constructor(
    public id: number,
    public nombre: string = '',
    public imagen: string = '',
    public tipoCafeteria: string = '',
    public valoracionMedia: number = 0,
  ) {}
}
