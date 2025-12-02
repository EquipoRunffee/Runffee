import { Component } from '@angular/core';
import {ActivatedRoute, Router, RouterLinkActive, RouterModule} from '@angular/router';
import {EntrenamientoService} from '@core/services/entrenamiento/entrenamientoService';
import {MapaEntrenamiento} from '@loged/components/perfil/mapa-entrenamiento/mapa-entrenamiento';
import {DecimalPipe} from '@angular/common';
import {MapaCafeteria} from '@shared/components/mapa-cafeteria/mapa-cafeteria';
import {QrPedido} from '@loged/components/perfil/qr-pedido/qr-pedido';

@Component({
  selector: 'app-actividad',
  imports: [RouterModule, MapaEntrenamiento, DecimalPipe, MapaCafeteria, QrPedido],
  templateUrl: './actividad.html',
  styleUrl: './actividad.css',
})
export class Actividad {

  idEntrenamiento: number;
  datos: any;
  datosCargados: boolean = false;

  constructor(private router: Router, private rutaActiva: ActivatedRoute, private entrenamientoService: EntrenamientoService) {

    this.idEntrenamiento = this.rutaActiva.snapshot.params['idEntrenamiento'];
    entrenamientoService.getEntrenamientoPerfil(this.idEntrenamiento).subscribe({
      next: (data: any) => {
        console.log(data);
        this.datosCargados = true;
        this.datos = data;
      },
      error: (error: any) => {
        console.log(error);
      }
    })
  }

  transformarAMinutos(segundos: number){
    const minutos = Math.floor(segundos / 60);
    const segs = segundos % 60;

    // PadStart añade un cero a la izquierda si es necesario
    const minutosStr = minutos.toString().padStart(2, '0');
    const segundosStr = segs.toString().padStart(2, '0');

    return `${minutosStr}:${segundosStr}`;
  }

  transformarARitmo(segundos: number, kilometros: number): string{
    if (kilometros <= 0) return "0:00 / km"; // Evitar división por cero

    const segundosPorKm = segundos / kilometros;

    const minutos = Math.floor(segundosPorKm / 60);
    const segs = Math.round(segundosPorKm % 60); // redondeo para mostrar segundos exactos

    const minutosStr = minutos.toString().padStart(2, '0');
    const segundosStr = segs.toString().padStart(2, '0');

    return `${minutosStr}:${segundosStr}`;
  }

  transformarFecha(fechaIso: string){
    const fecha = new Date(fechaIso);

    const meses = [
      'Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
      'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'
    ];

    const dia = fecha.getDate();
    const mes = meses[fecha.getMonth()];
    const anio = fecha.getFullYear();
    const hora = fecha.getHours();
    const minutos = fecha.getMinutes().toString().padStart(2, '0');

    return `${dia} ${mes} ${anio}, ${hora}:${minutos}`;
  }

  transformarZona(zona: string):string{
    if (!zona) return '';

    //Eliminar "(GMT+xx:xx) " al inicio
    let resultado = zona.replace(/\(GMT[^\)]+\)\s*/, '');

    //Reemplazar "/" por ","
    resultado = resultado.replace('/', ', ');

    return resultado;
  }

}
