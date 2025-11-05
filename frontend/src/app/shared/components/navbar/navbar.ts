import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.html',
  styleUrls: ['./navbar.css']
})
export class NavbarComponent {
  isMenuOpen = false;

  constructor(public router: Router) {} // 👈 "public" para poder usar en template

  toggleMenu(): void {
    this.isMenuOpen = !this.isMenuOpen;
  }

  closeMenu(): void {
    this.isMenuOpen = false;
  }

  irHome(): void {
    this.router.navigate(['/home']); // 👈 navegación manual
  }
}
