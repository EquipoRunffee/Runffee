import {Component, OnInit} from '@angular/core';
import { Cafeteria } from '@core/services/cafeteria';

@Component({
  selector: 'app-cafeteria',
  templateUrl: './cafeteria.html',
  styleUrl: './cafeteria.css',
})

export class CafeteriaComponent implements OnInit{

  cafeterias: any[] = [];

  constructor(private cafeteriaService: Cafeteria ) {}

  ngOnInit(): void {
    this.cargarCafeterias();
  }

  cargarCafeterias(): void {
    this.cafeteriaService.getCafeteria().subscribe({
      next: (data) => {
        this.cafeterias = data;
        console.log('Datos recibidos:', data);
      },
      error: (err) => {
        console.error('Error al obtener cafeterías:', err);
      }
    });
  }
}
