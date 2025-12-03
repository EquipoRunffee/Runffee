import {Component} from '@angular/core';
import {LogedModule} from '@loged/loged-module';
import {RouterOutlet} from '@angular/router';
import {NgClass} from '@angular/common';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.html',
  styleUrl: './perfil.css',
  imports: [
    LogedModule,
    RouterOutlet,
    NgClass
  ],
  standalone: true
})
export class Perfil {
  estadoNavbar: boolean = true;

  mostrarNavbar(){
    this.estadoNavbar = !this.estadoNavbar;
  }
}
