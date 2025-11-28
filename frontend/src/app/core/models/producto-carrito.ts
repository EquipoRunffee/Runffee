export class ProductoCarrito {
  id: number;
  nombre: string;
  imagen: string;
  descripcion: string;
  tipo: string;
  precio: number;
  cantidad: number;

  constructor(id: number, nombre: string, imagen: string, descripcion: string, tipo: string, precio: number, cantidad: number) {
    this.id = id;
    this.nombre = nombre;
    this.imagen = imagen;
    this.descripcion = descripcion;
    this.tipo = tipo;
    this.precio = precio;
    this.cantidad = cantidad;
  }
}
