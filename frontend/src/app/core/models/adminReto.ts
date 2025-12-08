export class adminReto {
  nombre: string;
  descripcion: string;
  fecha_inicio: Date;
  fecha_fin: Date;
  eliminado: boolean;

  constructor(
    nombre: string,
    descripcion: string,
    fecha_inicio: Date,
    fecha_fin: Date,
    eliminado: boolean
  ) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.fecha_inicio = fecha_inicio;
    this.fecha_fin = fecha_fin;
    this.eliminado = eliminado;
  }
}
