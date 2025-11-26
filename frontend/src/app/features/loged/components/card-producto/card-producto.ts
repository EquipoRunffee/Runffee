import {Component, Input} from '@angular/core';
import {ProductoCarrito} from '@core/models/producto-carrito';
import {DecimalPipe} from '@angular/common';
import {ProductoSeleccion} from '@core/models/producto-seleccion';

@Component({
  selector: 'app-card-producto',
  standalone: true,
  templateUrl: './card-producto.html',
  styleUrl: './card-producto.css',
  imports: [
    DecimalPipe
  ]
})
export class CardProducto {
  @Input() producto!: ProductoSeleccion;
  cantidad: number = 0;

  anadirCantidadProducto(){
    this.cantidad = ++this.cantidad;
  }

  eliminarCantidadProducto(){
    if(this.cantidad > 0){
      this.cantidad = --this.cantidad;
    }
  }
}
