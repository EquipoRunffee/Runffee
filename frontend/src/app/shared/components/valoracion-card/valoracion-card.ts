import {Component, Input} from '@angular/core';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-valoracion-card',
  standalone: true,
  templateUrl: './valoracion-card.html',
  styleUrl: './valoracion-card.css',
  imports: [CommonModule]
})
export class ValoracionCard {
  @Input() nombreCafeteria: string = '';
  @Input() titulo: string = '';
  @Input() descripcion: string = '';
  @Input() cantidad: number = 0;



}
