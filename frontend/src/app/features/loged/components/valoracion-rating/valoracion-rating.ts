import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {NgStyle} from '@angular/common';

@Component({
  selector: 'app-valoracion-rating',
  standalone: true,
  templateUrl: './valoracion-rating.html',
  styleUrl: './valoracion-rating.css',
  imports: [
    NgStyle
  ]
})
export class ValoracionRating implements OnInit {
  value: number = 3;
  @Output() cambioValor = new EventEmitter<number>();

  estrellas = Array(5).fill(0);
  hover = 0;

 ngOnInit() {
   this.cambioValor.emit(this.value);
 }

  establecerValor(event: MouseEvent, index: number) {
    const rect = (event.target as HTMLElement).getBoundingClientRect();
    const x = event.clientX - rect.left;
    const fraction = x / rect.width;
    const newValue = index + (fraction >= 0.5 ? 1 : 0.5);
    this.value = newValue;
    this.cambioValor.emit(this.value);
  }

  actualizarHover(event: MouseEvent, index: number) {
    const rect = (event.target as HTMLElement).getBoundingClientRect();
    const x = event.clientX - rect.left;
    const fraction = x / rect.width;
    this.hover = index + (fraction >= 0.5 ? 1 : 0.5);
  }

  obtenerRelleno(index: number): number {
    const val = this.hover || this.value;
    if (val >= index + 1) return 100;
    if (val >= index + 0.5) return 50;
    return 0;
  }
}
