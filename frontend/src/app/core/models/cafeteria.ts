export class Cafeteria {
  nombre: string;
  descripcion: string;
  lat: number;
  lng: number;
  imagen: string;
  tipo: string;
  eliminado: string;

  constructor(
    nombre: string = '',
    descripcion: string = '',
    lat: number = 0,
    lng: number = 0,
    imagen: string = '',
    tipo: string = '',
    eliminado: string = ''
  ) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.lat = lat;
    this.lng = lng;
    this.imagen = imagen;
    this.tipo = tipo;
    this.eliminado = eliminado;
  }
}
