import {Cafeteria} from '@core/models/cafeteria';

export interface Producto {

  nombre: string;
  imagen: string;
  precio: number;
  descripcion: string;
  eliminado: string;
  idCafeteria: Cafeteria;
}
