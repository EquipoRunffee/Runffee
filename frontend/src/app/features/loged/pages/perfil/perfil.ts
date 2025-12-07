import {Component, OnInit} from '@angular/core';
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
export class Perfil implements OnInit {
  estadoNavbar: boolean = false;

  ngOnInit() {
    if (window.innerWidth > 500){this.estadoNavbar = true;}
  }

  toggleNavbar(){
    if (window.innerWidth > 500){this.estadoNavbar = true;} else {
      this.estadoNavbar = !this.estadoNavbar;
    }
  }
}
