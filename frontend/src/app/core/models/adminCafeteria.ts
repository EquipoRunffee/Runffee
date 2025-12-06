export class adminCafeteria {
  nombre: string;
  descripcion: string;
  lat: number;
  lng: number;
  imagen: string;
  tipoCafeteria: string;
  eliminado: boolean;

  constructor(nombre: string, descripcion: string, lat: number, lng: number, imagen: string, tipoCafeteria: string, eliminado: boolean) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.lat = lat;
    this.lng = lng;
    this.imagen = imagen;
    this.tipoCafeteria = tipoCafeteria;
    this.eliminado = eliminado;
  }

}
