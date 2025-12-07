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
  @Input() datos: any;
  copiadoEstado: boolean = false;

  copiarAlPortapapeles(cuponNombre: string) {
    navigator.clipboard.writeText(cuponNombre)
      .then(() => {
        this.copiadoEstado = true;
        setTimeout(() => {
          this.copiadoEstado = false;
        }, 1500);
      })
      .catch(err => {
        console.error('Error al copiar al portapapeles:', err);
      });
  }
}
