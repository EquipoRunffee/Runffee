import {Component, OnInit} from '@angular/core';
import {Router, RouterModule} from '@angular/router';
import {AppModule} from '../../../../app-module';
import {EntrenamientoCard} from '@shared/components/entrenamiento-card/entrenamiento-card';

@Component({
  selector: 'app-entrenamiento',
  imports: [RouterModule, EntrenamientoCard],
  templateUrl: './entrenamiento.html',
  styleUrl: './entrenamiento.css',
})
export class Entrenamiento {

  // entrenamiento: entrenamientoDetalles = {
  //   nombre:'',
  //   fecha: null,
  //   distancia: 0
  // }
  //
  // constructor(private router: Router, private entrenamientoService: EntrenamientoService) {}
  //
  //
  // ngOnInit() {
  //   const usuarioId = 15;
  //   this.entrenamientoService.getEntrenamientoDetalles(usuarioId).subscribe(
  //
  //   )
  // }
}
