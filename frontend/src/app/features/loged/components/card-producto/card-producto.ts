import {Component, Input} from '@angular/core';
import {ProductoCarrito} from '@core/models/producto-carrito';
import {DecimalPipe} from '@angular/common';

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
  @Input() producto!: ProductoCarrito;
}
