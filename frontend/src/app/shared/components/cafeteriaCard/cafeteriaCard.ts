import { Component, OnInit } from '@angular/core';
import {CafeteriaService} from '@core/services/cafeteria';
import { CommonModule } from '@angular/common';
import {Cafeteria} from '@shared/class/cafeteria';

@Component({
  selector: 'app-cafeteriaCard',
  templateUrl: './cafeteriaCard.html',
  styleUrl: './cafeteriaCard.css',
  standalone: true,
  imports: [CommonModule]
})

export class CafeteriaCard implements OnInit{
  cafeterias: Cafeteria[] = [];

  constructor(private cafeteriaService: CafeteriaService) {}

  ngOnInit(): void {
    this.cargarCafeterias();
  }

  cargarCafeterias(): void {
    this.cafeteriaService.getCafeteria().subscribe({
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
