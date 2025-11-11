import { Component } from '@angular/core';
import {Router, RouterModule} from '@angular/router';

@Component({
  selector: 'app-entrenamiento',
  imports: [RouterModule],
  templateUrl: './entrenamiento.html',
  styleUrl: './entrenamiento.css',
})
export class Entrenamiento {
    constructor(private router: Router) {}
    mostrarActividad() {
      this.router.navigate(['/perfil/actividad']);
    }

}
