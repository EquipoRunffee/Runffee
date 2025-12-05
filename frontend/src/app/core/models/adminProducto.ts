export class adminProducto {
  nombre: string;
  tipoProducto: string;
  imagen: string;
  precio: number;
  descripcion: string;
  eliminado: boolean;
  idCafeteria: number;

  constructor(nombre: string, tipoProducto: string, imagen: string, precio: number, descripcion: string, eliminado: boolean, idCafeteria: number) {
    this.nombre = nombre;
    this.tipoProducto = tipoProducto;
    this.imagen = imagen;
    this.precio = precio;
    this.descripcion = descripcion;
    this.eliminado = eliminado;
    this.idCafeteria = idCafeteria;
  }
}
