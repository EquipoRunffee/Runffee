import { Component, OnInit } from '@angular/core';
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

  constructor(private cafeteriaDetalleService: CafeteriaDetallesService) {}

  ngOnInit(): void {
    this.cargarCafeterias();
  }

  cargarCafeterias(): void {
    this.cafeteriaDetalleService.getCafeteriaDetalle().subscribe({
      next: (data: any) => {
        this.cafeterias = data;
        console.log('Datos recibidos:', data);
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

}
