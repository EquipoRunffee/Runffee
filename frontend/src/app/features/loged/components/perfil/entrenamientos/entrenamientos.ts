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
  entrenamientosCargados: boolean = false;
  mostrarMensajesEstado:boolean = false;
  textoMensajes:string = "";

  constructor(private entrenamientoDetallesService: EntrenamientoDetallesService, private router: Router, private rutaActiva: ActivatedRoute) { }

  ngOnInit(): void {
    this.cargarEntrenamientos();
  }

  cargarEntrenamientos(): void {
    this.entrenamientoDetallesService.getEntrenamientoDetalle().subscribe({
      next: (data: any) => {
        // Cargamos datos
        this.entrenamientos = data;
        this.entrenamientosCargados = true;
      },
      error: (err) => {
        console.error('Error al obtener entrenamiento:', err);
      }
    });
  }

  mostrarMensajes(mensaje: string):void{
    this.mostrarMensajesEstado = true;
    this.textoMensajes = mensaje;
    setTimeout(() => {
      this.mostrarMensajesEstado = false;
    }, 3000)
  }

  cuponGeneradoEntrenamiento():void{
      this.mostrarMensajes("¡Reto cumplido! Has obtenido un cupón");
      setTimeout(() => {
        window.location.reload();
      }, 3000);
  }
}
