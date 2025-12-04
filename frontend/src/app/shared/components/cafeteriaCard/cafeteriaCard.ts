import {Component, ElementRef, EventEmitter, OnInit, Output, ViewChild} from '@angular/core';
import { CommonModule } from '@angular/common';
import {CafeteriaDetalles} from '@core/models/cafeteria-detalles';
import {CafeteriaDetallesService} from '@core/services/cafeteria/cafeteriaDetallesService';
import {ActivatedRoute, Router, RouterLink} from '@angular/router';
import {CarritoService} from '@core/services/carrito/carritoService';

@Component({
  selector: 'app-cafeteriaCard',
  templateUrl: './cafeteriaCard.html',
  styleUrl: './cafeteriaCard.css',
  standalone: true,
  imports: [CommonModule, RouterLink]
})

export class CafeteriaCard implements OnInit{
  isCafeteriasLoaded: boolean = false;
  cafeterias: CafeteriaDetalles[] = [];
  // Definimos los valores que tiene el objeto, la key(tipoCafeteria es obligatoria un string mientras
  // los valores pueden ser cualquiera)
  cafeteriaPorTipo: { [key: string]: any[] } = {};
  @Output() mostrarMensaje = new EventEmitter<string>();

  @ViewChild('hostCard') hostCard!: ElementRef;

  constructor(private carritoService: CarritoService, private cafeteriaDetalleService: CafeteriaDetallesService, private router: Router, private rutaActiva: ActivatedRoute) { }

  ngOnInit(): void {
    this.cargarCafeterias();
  }

  scrollTo() {
    this.hostCard.nativeElement.scrollIntoView({ behavior: 'smooth' });
  }

  cargarCafeterias(): void {
    this.cafeteriaDetalleService.getCafeteriaDetalle().subscribe({
      next: (data: any) => {
        // Cargamos datos
        this.cafeterias = data;
        // Añadimos la nueva funcion
        this.filtrarCafeteriasPorTipo();
        this.isCafeteriasLoaded = true;
      },
      error: (err) => {
        console.error('Error al obtener cafeterías:', err);
      }
    });
  }

  filtrarCafeteriasPorTipo() {
    // Creamos objeto vacio
    this.cafeteriaPorTipo = {};

    // Bucle para filtrar por tipo recorriendo cada cafeteria en la lista
    for(let cafeteria of this.cafeterias) {
      let tipo = cafeteria.tipoCafeteria;

      // Comprueba si existe ese tipo de cafeteria
      if(tipo in this.cafeteriaPorTipo){this.cafeteriaPorTipo = {
          // Muestra todas las cafeterias diferenciadas por tipo
          ...this.cafeteriaPorTipo,
          // Filtra segun el tipo requerido
          [tipo]: [...this.cafeteriaPorTipo[tipo], cafeteria]
        };
      // Sino existe ese tipo de caferia en nuetro objeto
      } else {
        this.cafeteriaPorTipo = {
          // Muestra todas las cafeterias diferenciadas por tipo
          ...this.cafeteriaPorTipo,
          // Crea el nuevo tipo con esta cafetería
          [tipo]: [cafeteria]
        };
      }
    }
  }

  irACafeteria(id: number):void{
    if(this.carritoService.getCarrito().idReto == null && this.carritoService.getKmObjetivo() == null && this.carritoService.getTiempoObjetivo() == null){
      this.mostrarMensaje.emit("¡Ups! Parece que no has seleccionado ningún reto u objetivo.")
    } else {
      this.router.navigate(['seleccion-productos', id], {relativeTo: this.rutaActiva });
    }
  }
}
