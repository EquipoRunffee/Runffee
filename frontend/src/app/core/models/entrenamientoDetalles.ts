export class EntrenamientoDetalles {
  constructor(
    public nombre: string = '',
    public fecha_fin: Date = new Date(),
    public distancia: number = 1,
  ) {}
}
