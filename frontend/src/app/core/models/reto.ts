export class Reto {
  constructor(
    public id: number,
    public nombre: string = '',
    public descripcion: string = '',
    public fechaInicio: Date = new Date(),
    public fechaFin: Date = new Date(),
    public km: number,
    public tiempo: number,
    public eliminado: string = 'false'
  ) {}
}
