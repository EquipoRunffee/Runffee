import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router, RouterModule} from '@angular/router';
import {EntrenamientoCard} from '@shared/components/entrenamiento-card/entrenamiento-card';
import {NgForOf} from '@angular/common';
import {EntrenamientoDetalles} from '@core/models/entrenamientoDetalles';
import {EntrenamientoDetallesService} from '@core/services/entrenamiento/entrenamientoDetallesService';

@Component({
  selector: 'app-entrenamientos',
  imports: [RouterModule, EntrenamientoCard],
  templateUrl: './entrenamientos.html',
  styleUrls: ['./entrenamientos.css'],
})
export class Entrenamientos implements OnInit {

  entrenamientos: EntrenamientoDetalles[] = [];

  constructor(private entrenamientoDetallesService: EntrenamientoDetallesService, private router: Router, private rutaActiva: ActivatedRoute) { }

  ngOnInit(): void {
    this.cargarEntrenamientos();
  }

  cargarEntrenamientos(): void {
    this.entrenamientoDetallesService.getEntrenamientoDetalle().subscribe({
      next: (data: any) => {
        // Cargamos datos
        this.entrenamientos = data;
        console.log('Datos Recibidos:', data);
      },
      error: (err) => {
        console.error('Error al obtener entrenamiento:', err);
      }
    });
  }

  irEntrenamiento(id: number) {
    this.router.navigate(['entrenamiento', id], {relativeTo: this.rutaActiva });
  }

}
