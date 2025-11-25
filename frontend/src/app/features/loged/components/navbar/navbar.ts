import { Component } from '@angular/core';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-navbar',
  standalone: true,
  templateUrl: './navbar.html',
  styleUrl: './navbar.css',
  imports: [CommonModule]
})
export class Navbar {
  muestraCarrito: boolean = false;

  mostrarCarrito() {
    this.muestraCarrito = !this.muestraCarrito;
  }
}
