import { Component } from '@angular/core';
import {RouterModule} from '@angular/router';
import {Entrenamiento} from '@loged/components/entrenamiento/entrenamiento';

@Component({
  selector: 'app-actividades',
  imports: [RouterModule, Entrenamiento],
  templateUrl: './actividades.html',
  styleUrls: ['./actividades.css'],
})
export class Actividades {

}
