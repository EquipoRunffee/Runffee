export class adminCafeteria {
  nombre: string;
  descripcion: string;
  latitud: string;
  longitud: string;
  imagen: string;
  tipoCafeteria: string;
  eliminado: boolean;

  constructor(nombre: string, descripcion: string, latitud: string, longitud: string, imagen: string, tipoCafeteria: string, eliminado: boolean) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.latitud = latitud;
    this.longitud = longitud;
    this.imagen = imagen;
    this.tipoCafeteria = tipoCafeteria;
    this.eliminado = eliminado;
  }

}
