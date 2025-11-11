import { Component } from '@angular/core';
import {LogedModule} from '@loged/loged-module';
import {RouterOutlet} from '@angular/router';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrl: './perfil.component.css',
  imports: [
    LogedModule,
    RouterOutlet
  ],
  standalone: true
})
export class PerfilComponent {

}
