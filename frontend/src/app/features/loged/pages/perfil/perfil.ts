import {Component} from '@angular/core';
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
export class Perfil {}
