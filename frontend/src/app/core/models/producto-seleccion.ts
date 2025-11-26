export class ProductoSeleccion {
  id: number;
  nombre: string;
  imagen: string;
  descripcion: string;
  tipo: string;
  precio: number;

  constructor(id: number, nombre: string, imagen: string, descripcion: string, tipo: string, precio: number) {
    this.id = id;
    this.nombre = nombre;
    this.imagen = imagen;
    this.descripcion = descripcion;
    this.tipo = tipo;
    this.precio = precio;
  }
}
