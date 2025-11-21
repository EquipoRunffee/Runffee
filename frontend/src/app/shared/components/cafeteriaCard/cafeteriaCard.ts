import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import { CommonModule } from '@angular/common';
import {CafeteriaDetalles} from '@core/models/cafeteria-detalles';
import {CafeteriaDetallesService} from '@core/services/cafeteria/cafeteriaDetallesService';

@Component({
  selector: 'app-cafeteriaCard',
  templateUrl: './cafeteriaCard.html',
  styleUrl: './cafeteriaCard.css',
  standalone: true,
  imports: [CommonModule]
})

export class CafeteriaCard implements OnInit{
  cafeterias: CafeteriaDetalles[] = [];
  // Definimos los valores que tiene el objeto, la key(tipoCafeteria es obligatoria un string mientras
  // los valores pueden ser cualquiera)
  cafeteriaPorTipo: { [key: string]: any[] } = {};

  @ViewChild('hostCard') hostCard!: ElementRef;


  constructor(private cafeteriaDetalleService: CafeteriaDetallesService) {}

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
        console.log('Datos Recibidos:', data);
        console.log('Cafeterías por tipo:', this.cafeteriaPorTipo);
      },
      error: (err) => {
        console.error('Error al obtener cafeterías:', err);
      }
    });
  }

  capitalizeTipo(tipoCafeteria?: string): string {
    if (!tipoCafeteria) return '';
    if (tipoCafeteria === 'CAFETERIA') tipoCafeteria = 'CAFETERÍAS';
    return tipoCafeteria.charAt(0).toUpperCase() + tipoCafeteria.slice(1).toLowerCase();
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
}
