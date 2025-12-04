import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
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

  constructor(private router: Router, private rutaActiva: ActivatedRoute, private entrenamientoService: EntrenamientoService) { }
  irEntrenamiento(id: number) {
    this.router.navigate(['entrenamiento', id], {relativeTo: this.rutaActiva });
  }

  finalizarEntrenamiento(idEntrenamiento: number):void {
    this.entrenamientoService.finalizarEntrenamiento(idEntrenamiento).subscribe({
      next: (result) => {
        window.location.reload()
        console.log(result);
      },
      error: (error) => {
        console.error(error);
      }
    })
  }

  convertirFecha(fecha: string): string {
    const [anio, mes, dia] = fecha.split("-");
    return `${dia}-${mes}-${anio}`;
  }
}
