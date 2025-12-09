import { Component } from '@angular/core';
import {ActivatedRoute, Router, RouterLinkActive, RouterModule} from '@angular/router';
import {EntrenamientoService} from '@core/services/entrenamiento/entrenamientoService';
import {MapaEntrenamiento} from '@loged/components/perfil/mapa-entrenamiento/mapa-entrenamiento';
import {DecimalPipe} from '@angular/common';
import {MapaCafeteria} from '@shared/components/mapa-cafeteria/mapa-cafeteria';
import {QrPedido} from '@loged/components/perfil/qr-pedido/qr-pedido';
import {PedidoService} from '@core/services/pedido/pedidoService';
import {LogedModule} from '@loged/loged-module';
import {ValoracionRating} from '@loged/components/valoracion-rating/valoracion-rating';
import {FormsModule} from '@angular/forms';
import {ValoracionService} from '@core/services/valoracion/valoracionesService';

@Component({
  selector: 'app-actividad',
  imports: [RouterModule, MapaEntrenamiento, DecimalPipe, MapaCafeteria, QrPedido, ValoracionRating, FormsModule],
  templateUrl: './actividad.html',
  styleUrl: './actividad.css',
})
export class Actividad {

  idEntrenamiento: number;
  datos: any;
  datosCargados: boolean = false;
  popUpValoracionEstado:boolean = false;

  puntuacionValoracion: number | null = null;
  tituloValoracion:string = "";
  descripcionValoracion:string = "";
  valoracionDatos:any;

  mostrarMensajesEstado:boolean = false;
  textoMensajes:string = "";

  constructor(private router: Router, private rutaActiva: ActivatedRoute, private entrenamientoService: EntrenamientoService, private pedidoService: PedidoService, private valoracionService: ValoracionService) {

    this.idEntrenamiento = this.rutaActiva.snapshot.params['idEntrenamiento'];
    entrenamientoService.getEntrenamientoPerfil(this.idEntrenamiento).subscribe({
      next: (data: any) => {
        console.log(data);
        this.datosCargados = true;
        this.datos = data;
        if(this.datos.pedido.valoracion == null){
          this.popUpValoracionEstado = true;
        }
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

  confirmarRecogida(){
    if(this.datos.pedido.id != null){
      this.pedidoService.entregarPedido(this.datos.pedido.id).subscribe({
        next: (data: any) => {
            this.popUpValoracion();
        },
        error: (error: any) => {
          console.log(error);
        }
      })
    }
  }

  popUpValoracion(){
    this.popUpValoracionEstado = true;
  }

  setPuntuacionValoracion(puntuacion: number){
    this.puntuacionValoracion = puntuacion;
  }

  enviarValoracion(){
    if(this.tituloValoracion == "" || this.descripcionValoracion == "" || this.puntuacionValoracion == 0 || this.puntuacionValoracion == null){
      this.mostrarMensajes("Faltan datos por rellenar");
    }else{
      if(this.datos != null && this.datos.pedido != null){
        this.valoracionDatos = {
          "idPedido": this.datos.pedido.id,
          "titulo": this.tituloValoracion,
          "descripcion": this.descripcionValoracion,
          "cantidad": this.puntuacionValoracion
        }
        this.valoracionService.enviarValoracion(this.valoracionDatos).subscribe({
          next: (data: any) => {
            this.mostrarMensajes("¡Valoración enviada!");
            setTimeout(() => {
              window.location.reload();
            }, 3000)
          },
          error: (error: any) => {
            this.mostrarMensajes(error.message);
          }
        })
      }
    }
  }

  mostrarMensajes(mensaje: string):void{
    this.mostrarMensajesEstado = true;
    this.textoMensajes = mensaje;
    setTimeout(() => {
      this.mostrarMensajesEstado = false;
    }, 3000)
  }
}
