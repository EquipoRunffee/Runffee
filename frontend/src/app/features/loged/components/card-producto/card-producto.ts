import {Component, Input, OnInit} from '@angular/core';
import {DecimalPipe, NgClass} from '@angular/common';
import {ProductoSeleccion} from '@core/models/producto-seleccion';
import {Router} from '@angular/router';
import {CarritoService} from '@core/services/carrito/carritoService';

@Component({
  selector: 'app-card-producto',
  standalone: true,
  templateUrl: './card-producto.html',
  styleUrl: './card-producto.css',
  imports: [
    DecimalPipe,
    NgClass
  ]
})
export class CardProducto implements OnInit {
  @Input() producto!: ProductoSeleccion;
  @Input()  modo: 'productos' | 'carrito' = 'productos';
  cantidad: number = 0;


  constructor(private carritoService: CarritoService, private router: Router) {}

  ngOnInit() {
    this.carritoService.carrito$.subscribe(carrito => {
      const prod = carrito.productosCarrito.find(p => p.id === this.producto.id);
      this.cantidad = prod ? prod.cantidad : 0;
    });
  }

  anadirCantidadProducto() {
    this.cantidad++;
    this.carritoService.anadirProducto({
      id: this.producto.id,
      nombre: this.producto.nombre,
      precio: this.producto.precio,
      cantidad: 1,
      imagen: this.producto.imagen,
      descripcion: this.producto.descripcion,
      tipo: this.producto.tipo
    });
  }

  eliminarCantidadProducto() {
    if (this.cantidad > 0) {
      this.cantidad--;
      this.carritoService.eliminarProducto(this.producto.id, 1);
    }
  }
}
