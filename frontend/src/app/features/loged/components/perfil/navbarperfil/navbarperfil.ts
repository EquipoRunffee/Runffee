import { Component, EventEmitter, Output } from '@angular/core';
import {Router, RouterModule} from '@angular/router';
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

  constructor(private router: Router) {}

  navigate(route: string) {
    this.router.navigate([route]);
    this.itemSelected.emit(); // cerrar menú en móvil
  }

}
