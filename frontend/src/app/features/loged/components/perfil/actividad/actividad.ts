import { Component } from '@angular/core';
import {ActivatedRoute, Router, RouterLinkActive, RouterModule} from '@angular/router';
import {EntrenamientoService} from '@core/services/entrenamiento/entrenamientoService';

@Component({
  selector: 'app-actividad',
  imports: [RouterModule],
  templateUrl: './actividad.html',
  styleUrl: './actividad.css',
})
export class Actividad {

  idEntrenamiento: number;
  datos: any;

  constructor(private router: Router, private rutaActiva: ActivatedRoute, private entrenamientoService: EntrenamientoService) {

    this.idEntrenamiento = this.rutaActiva.snapshot.params['idEntrenamiento'];
    entrenamientoService.getEntrenamientoPerfil(this.idEntrenamiento).subscribe({
      next: (data: any) => {
        console.log(data);
      },
      error: (error: any) => {
        console.log(error);
      }
    })
  }


}
