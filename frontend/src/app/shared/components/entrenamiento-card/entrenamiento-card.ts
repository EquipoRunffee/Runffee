import { Component, OnInit } from '@angular/core';
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
export class EntrenamientoCard implements OnInit {

  entrenamientos: EntrenamientoDetalles[] = [];

  constructor(
    private router: Router,
    private entrenamientoDetallesService: EntrenamientoDetallesService
  ) {}

  ngOnInit(): void {
    this.cargarEntrenamientos();
  }

  mostrarActividad() {
    this.router.navigate(['app/perfil/actividad']);
  }

  cargarEntrenamientos(): void {
    this.entrenamientoDetallesService.getEntrenamientoDetalle().subscribe({
      next: (data: any[]) => {
        this.entrenamientos = data;
        console.log('Datos Recibidos:', data);
      },
      error: (err) => {
        console.error('Error al obtener cafeterías:', err);
      }
    });
  }
}
