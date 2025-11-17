import {Component, HostListener} from '@angular/core';
import {LogedModule} from '@loged/loged-module';
import {RouterOutlet} from '@angular/router';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.html',
  styleUrl: './perfil.css',
  imports: [
    LogedModule,
    RouterOutlet
  ],
  standalone: true
})
export class Perfil {

  isMobile = false;
  isNavbarOpen = false;

  constructor() {
    this.checkScreenSize();
  }

  @HostListener('window:resize')
  checkScreenSize() {
    this.isMobile = window.innerWidth <= 500;
    if (!this.isMobile) {
      this.isNavbarOpen = false;
    }
  }

  toggleNavbar() {
    this.isNavbarOpen = !this.isNavbarOpen;
  }

  closeNavbar() {
    this.isNavbarOpen = false;
  }

}
