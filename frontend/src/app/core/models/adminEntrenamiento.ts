export class adminEntrenamiento {
  nombre: string;
  fecha_inicio: Date;
  fecha_fin: Date;
  kmObjetivo: number;
  tiempoObjetivo: number;
  completado: boolean;
  eliminado: boolean;

  constructor(
    nombre: string,
    fecha_inicio: Date,
    fecha_fin: Date,
    kmObjetivo: number,
    tiempoObjetivo: number,
    completado: boolean,
    eliminado: boolean
  ) {
    this.nombre = nombre;
    this.fecha_inicio = fecha_inicio;
    this.fecha_fin = fecha_fin;
    this.kmObjetivo = kmObjetivo;
    this.tiempoObjetivo = tiempoObjetivo;
    this.completado = completado;
    this.eliminado = eliminado;
  }
}
