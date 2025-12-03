import {Component, Input} from '@angular/core';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-cupon',
  templateUrl: './cupon.html',
  styleUrl: './cupon.css',
  standalone: true,
  imports: [CommonModule]
})
export class Cupon {
  @Input() nombre: string = '';
  @Input() fechaCaducidad: Date = new Date();
  @Input() imagen: string = '';
  @Input() porcentaje: number = 0;
  @Input() descripcion: string = '';
  @Input() usado: boolean = false;
}
