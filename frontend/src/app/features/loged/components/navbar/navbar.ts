import {Component, OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterLink} from '@angular/router';
import {UsuarioService} from '@core/services/usuario/usuarioService';
import {CarritoService} from '@core/services/carrito/carritoService';
import {Carrito} from '@core/models/carrito';
import {CardProducto} from '@loged/components/card-producto/card-producto';
import {PedidoService} from '@core/services/pedido/pedidoService';

@Component({
  selector: 'app-navbar',
  standalone: true,
  templateUrl: './navbar.html',
  styleUrl: './navbar.css',
  imports: [CommonModule, RouterLink, CardProducto]
})
export class Navbar implements OnInit {
  muestraCarrito: boolean = false;
  urlFotoUsuario: string | null = null;
  carrito: Carrito;

  mostrarCarrito() {
    this.muestraCarrito = !this.muestraCarrito;
  }

  constructor(private usuarioService: UsuarioService, private carritoService: CarritoService, private pedidoService: PedidoService) {
    this.carrito = carritoService.getCarrito();
  }

  ngOnInit() {
    this.usuarioService.getFotoUsuario().subscribe({
      next: data => {
        this.urlFotoUsuario = data.url;
      },
      error: error => {
        console.log(error);
      }
    })
  }

  crearPedido() {
    this.pedidoService.crearPedido(this.carrito).subscribe({
      next: data => {
        console.log(data);
      },
      error: error => {
        console.log(error);
      }
    })
  }
}
