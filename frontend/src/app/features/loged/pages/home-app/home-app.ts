import {Component, ViewChild, ElementRef, OnInit} from '@angular/core';
import { CafeteriaCard } from '@shared/components/cafeteriaCard/cafeteriaCard';
import {CardReto} from '@loged/components/card-reto/card-reto';
import {Footer} from '@shared/components/footer/footer';
import {Navbar} from '@loged/components/navbar/navbar';
import {RetoService} from '@core/services/reto/retoService';
import {Reto} from '@core/models/reto';
import {CarritoService} from '@core/services/carrito/carritoService';
import {NgClass} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {EntrenamientoCard} from '@shared/components/entrenamiento-card/entrenamiento-card';
import {EntrenamientoService} from '@core/services/entrenamiento/entrenamientoService';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-home-app',
  standalone: true,
  templateUrl: './home-app.html',
  styleUrls: ['./home-app.css'],
  imports: [CafeteriaCard, CardReto, Footer, Navbar, FormsModule, EntrenamientoCard, RouterLink]
})
export class HomeApp implements OnInit {
  mes = new Date().toLocaleString('es-ES', { month: 'long' });
  selectedIndexReto: number | null = null;
  popUp: HTMLElement | null = null;
  @ViewChild(CafeteriaCard) contenedor!: CafeteriaCard;
  retos: Reto[] | null = null;
  mostrarMensajesEstado:boolean = false;
  mostrarPopUpCrearObjetivo: boolean = false;
  textoMensajes:string = "";
  datosUltimoEntrenamiento:any;

  kmObjetivo: string = "";
  tiempoObjetivo: string = "";

  constructor(private retoService: RetoService, private carritoService: CarritoService, private entrenamientoService: EntrenamientoService) {}

  ngOnInit() {
    this.obtenerUltimoEntrenamiento();
    this.retoService.getReto().subscribe({
      next: data => {
        this.retos = data;
      },
      error: err => {
        console.log(err);
      }
    })
  }

  onSelectedReto(i: number) {
    if (this.selectedIndexReto === i) {
      this.selectedIndexReto = null;
    } else {
      this.selectedIndexReto = i;
      this.contenedor.scrollTo();
      this.mostrarMensajes("¡Yuhh! Reto seleccionado. Vamos a elegir la cafetería.");
      this.carritoService.setKmObjetivo(null);
      this.carritoService.setTiempoObjetivo(null);
    }
    this.carritoService.setIdReto(this.selectedIndexReto)
  }

  actualizarPopUp(){
    this.mostrarPopUpCrearObjetivo = !this.mostrarPopUpCrearObjetivo;
  }

  crearEntrenamiento(){
    if(this.tiempoObjetivo == null || this.tiempoObjetivo == "" || this.kmObjetivo == null || this.tiempoObjetivo == "" || parseFloat(this.kmObjetivo) < 1){
      this.mostrarMensajes("No se puede crear este entrenamiento. Prueba con otros datos")
    } else {
      this.carritoService.setTiempoObjetivo(parseInt(this.tiempoObjetivo)*60);
      this.carritoService.setKmObjetivo(parseFloat(this.kmObjetivo));
      this.carritoService.setIdReto(null);
      this.mostrarMensajes("¡Yuhh! Objetivo creado. Vamos a elegir la cafetería.");
      this.contenedor.scrollTo();
      this.actualizarPopUp()
    }
  }

  mostrarMensajes(mensaje: string):void{
      this.mostrarMensajesEstado = true;
      this.textoMensajes = mensaje;
      setTimeout(() => {
        this.mostrarMensajesEstado = false;
      }, 3000)
  }

  obtenerUltimoEntrenamiento():void{
    this.entrenamientoService.obtenerUltimoEntrenamiento().subscribe({
      next: data => {
        console.log(data);
        this.datosUltimoEntrenamiento = data;
      },
      error: err => {
        console.log(err);
      }
    })
  }
}
