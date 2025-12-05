export class adminProducto {
  descripcion: string;
  eliminado: boolean;
  idCafeteria: number;
  imagen: string;
  nombre: string;
  precio: number;
  tipoProducto: string;

  constructor(descripcion: string, eliminado: boolean, idCafeteria: number, imagen: string, nombre: string, precio: number, tipoProducto: string) {
    this.descripcion = descripcion;
    this.eliminado = eliminado;
    this.idCafeteria = idCafeteria;
    this.imagen = imagen;
    this.nombre = nombre;
    this.precio = precio;
    this.tipoProducto = tipoProducto;
  }
}
