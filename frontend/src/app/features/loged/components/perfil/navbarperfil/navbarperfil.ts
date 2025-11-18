import { Component, EventEmitter, HostListener, Output } from '@angular/core';
import {ActivatedRoute, Router, RouterModule} from '@angular/router';
import {NgOptimizedImage} from '@angular/common';

@Component({
  selector: 'app-navbarperfil',
  standalone: true,
  imports: [RouterModule, NgOptimizedImage],
  templateUrl: './navbarperfil.html',
  styleUrls: ['./navbarperfil.css'],
})
export class Navbarperfil {

  @Output() itemSelected = new EventEmitter<void>();

  isMobile = false;
  isNavbarOpen = false;

  constructor(private router: Router, private activatedRoute: ActivatedRoute) {
    this.checkScreenSize();
  }

  // Detectar tamaño de pantalla
  @HostListener('window:resize')
  checkScreenSize() {
    this.isMobile = window.innerWidth <= 500;
    if (!this.isMobile) {
      this.isNavbarOpen = false; // en escritorio siempre abierto
    }
  }

  // Toggle del menú en móvil
  toggleNavbar() {
    this.isNavbarOpen = !this.isNavbarOpen;
  }

  // Cerrar menú (cuando se selecciona un item)
  closeNavbar() {
    this.isNavbarOpen = false;
  }

  // Navegación relativa a /perfil
  navigate(route: string) {
    this.router.navigate([route], { relativeTo: this.activatedRoute });
    this.closeNavbar();       // cerrar menú en móvil
    this.itemSelected.emit(); // notificar al padre si es necesario
  }
}
