import { Component } from '@angular/core';
import {LogedModule} from '@loged/loged-module';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrl: './perfil.component.css',
  imports: [
    LogedModule
  ],
  standalone: true
})
export class PerfilComponent {

}
