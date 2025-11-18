import { Component, AfterViewInit, ViewChild, ElementRef } from '@angular/core';
import { CafeteriaCard } from '@shared/components/cafeteriaCard/cafeteriaCard';
import {CardReto} from '@loged/components/card-reto/card-reto';

@Component({
  selector: 'app-home-app',
  standalone: true,
  templateUrl: './home-app.html',
  styleUrls: ['./home-app.css'],
  imports: [CafeteriaCard, CardReto]
})
export class HomeApp{
  mes = new Date().toLocaleString('es-ES', { month: 'long' });
}
