import {Component, OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterLink} from '@angular/router';
import {UsuarioService} from '@core/services/usuario/usuarioService';

@Component({
  selector: 'app-navbar',
  standalone: true,
  templateUrl: './navbar.html',
  styleUrl: './navbar.css',
  imports: [CommonModule, RouterLink]
})
export class Navbar implements OnInit {
  muestraCarrito: boolean = false;
  urlFotoUsuario: string | null = null;

  mostrarCarrito() {
    this.muestraCarrito = !this.muestraCarrito;
  }

  constructor(private usuarioService: UsuarioService) {}

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
}
