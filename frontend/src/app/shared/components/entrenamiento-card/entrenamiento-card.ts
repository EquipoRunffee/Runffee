import {Component, Input, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import {EntrenamientoDetalles} from '@core/models/entrenamientoDetalles';
import { EntrenamientoDetallesService } from '@core/services/entrenamiento/entrenamientoDetallesService';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-entrenamiento-card',
  templateUrl: './entrenamiento-card.html',
  styleUrl: './entrenamiento-card.css',
  standalone: true,
  imports: [CommonModule]
})
export class EntrenamientoCard{

  constructor(private router: Router) {}

  mostrarActividad() {
    this.router.navigate(['app/perfil/actividad']);
  }

  @Input() nombre: string = '';
  @Input() fecha_fin!: Date;
  @Input() distancia: number = 1;
}
