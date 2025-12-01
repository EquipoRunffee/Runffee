import { Component, EventEmitter, HostListener, Output } from '@angular/core';
import {ActivatedRoute, Router, RouterModule} from '@angular/router';
import {NgOptimizedImage} from '@angular/common';
import {AuthService} from '@core/services/auth/auth-service';

@Component({
  selector: 'app-navbarperfil',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './navbarperfil.html',
  styleUrls: ['./navbarperfil.css'],
})
export class Navbarperfil {

  @Output() itemSelected = new EventEmitter<void>();

  isMobile = false;
  isNavbarOpen = false;

  constructor(private router: Router, private activatedRoute: ActivatedRoute, private authService: AuthService) {
    this.checkScreenSize();
  }

  // Detectar tamaño de pantalla
  @HostListener('window:resize')
  checkScreenSize() {
    this.isMobile = window.innerWidth <= 500;
    if (!this.isMobile) {
      this.isNavbarOpen = false;
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
    this.closeNavbar();
    this.itemSelected.emit();
  }

  cerrarSesion() {
    this.authService.logout();
    this.router.navigate(['home']);
  }
}
