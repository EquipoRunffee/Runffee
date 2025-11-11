import { Component, OnInit } from '@angular/core';
import { Cafeteria } from '@core/services/cafeteria';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-cafeteriaCard',
  templateUrl: './cafeteriaCard.html',
  styleUrl: './cafeteriaCard.css',
  standalone: true,
  imports: [CommonModule]
})

export class CafeteriaCard implements OnInit{
  cafeterias: Cafeteria[] = [];

  constructor(private cafeteriaService: Cafeteria) {}

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
}
