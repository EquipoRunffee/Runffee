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
  @Output() toggleNavbar = new EventEmitter<void>();

  constructor(private router: Router, private activatedRoute: ActivatedRoute, private authService: AuthService) {}

  navigate(route: string) {
    this.router.navigate([route], { relativeTo: this.activatedRoute });
    if (window.innerWidth <= 500){this.toggleNavbar.emit();}
    this.itemSelected.emit();
  }

  cerrarSesion() {
    this.authService.logout();
    this.router.navigate(['login']);
  }
}
