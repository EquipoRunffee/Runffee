import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
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
  @Output() cuponGenerado = new EventEmitter();
  @Output() errores = new EventEmitter<string>();

  constructor(private router: Router, private rutaActiva: ActivatedRoute, private entrenamientoService: EntrenamientoService) { }
  irEntrenamiento(id: number) {
    this.router.navigate(['entrenamiento', id], {relativeTo: this.rutaActiva });
  }

  finalizarEntrenamiento(idEntrenamiento: number):void {
    this.entrenamientoService.finalizarEntrenamiento(idEntrenamiento).subscribe({
      next: (result) => {
        if (result.finalizado) {
          if(result.body != null && result.body.cuponObtenido != null){
            this.cuponGenerado.emit();
          }
        } else {
          this.errores.emit(result.body.mensaje);
        }
      },
      error: (error) => {
        console.log(error);
      }
    })
  }

  convertirFecha(fecha: string): string {
    const [anio, mes, dia] = fecha.split("-");
    return `${dia}-${mes}-${anio}`;
  }
}
