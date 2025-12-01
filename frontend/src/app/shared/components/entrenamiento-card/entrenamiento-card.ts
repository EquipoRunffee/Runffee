import {Component, Input, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import {EntrenamientoDetalles} from '@core/models/entrenamientoDetalles';
import { EntrenamientoDetallesService } from '@core/services/entrenamiento/entrenamientoDetallesService';
import {CommonModule} from '@angular/common';
import {EntrenamientoService} from '@core/services/entrenamiento/entrenamientoService';

@Component({
  selector: 'app-entrenamiento-card',
  templateUrl: './entrenamiento-card.html',
  styleUrl: './entrenamiento-card.css',
  standalone: true,
  imports: [CommonModule]
})
export class EntrenamientoCard{

  @Input() datos: any;

  constructor(private router: Router, private entrenamientoService: EntrenamientoService) { }

  mostrarActividad() {
    this.router.navigate(['app/perfil/actividad']);
  }

  finalizarEntrenamiento(idEntrenamiento: number):void {
    this.entrenamientoService.finalizarEntrenamiento(idEntrenamiento).subscribe({
      next: (result) => {
        console.log(result);
      },
      error: (error) => {
        console.error(error);
      }
    })
  }
}
