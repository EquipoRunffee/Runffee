export class ProductoSeleccion {
  id: number;
  nombre: string;
  imagen: string;
  descripcion: string;
  tipoProducto: string;
  precio: number;

  constructor(id: number, nombre: string, imagen: string, descripcion: string, tipoProducto: string, precio: number) {
    this.id = id;
    this.nombre = nombre;
    this.imagen = imagen;
    this.descripcion = descripcion;
    this.tipoProducto = tipoProducto;
    this.precio = precio;
  }
}
