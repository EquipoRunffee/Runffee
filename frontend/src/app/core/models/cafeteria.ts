// IMPORTANTE : Los nombres tienen que ser iguales que en el backend

export class Cafeteria {
  constructor(
    public id: number,
    public nombre: string = '',
    public descripcion: string = '',
    public lat: string = '',
    public lng: string = '',
    public imagen: string = '',
    public tipoCafeteria: string = '',
    public eliminado: string = 'false',
  ) {}
}
