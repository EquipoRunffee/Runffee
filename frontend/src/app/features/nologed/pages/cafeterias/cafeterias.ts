import { Component } from '@angular/core';
import {MapaGoogle} from '@shared/components/mapa-google/mapa-google';
import {CafeteriaCard} from '@shared/components/cafeteriaCard/cafeteriaCard';

@Component({
  selector: 'app-cafeterias',
  standalone: true,
  templateUrl: './cafeterias.html',
  styleUrl: './cafeterias.css',
  imports: [
    MapaGoogle,
    CafeteriaCard
  ]
})
export class Cafeterias {

}
