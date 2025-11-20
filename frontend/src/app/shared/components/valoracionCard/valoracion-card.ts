import {Component, OnInit} from '@angular/core';
import {Valoracion} from '@core/models/valoracion';
import {ValoracionService} from '@core/services/valoracion/valoracionService';

@Component({
  selector: 'app-valoracionCard',
  standalone: false,
  templateUrl: './valoracion-card.html',
  styleUrl: './valoracion-card.css',
})
export class ValoracionCard implements OnInit{
  valoraciones: Valoracion[] = [];

  constructor(private valoracionService: ValoracionService) {}

  ngOnInit(): void {
    this.cargarValoraciones();
  }

  cargarValoraciones(): void {
    this.valoracionService.getValoracion().subscribe({
      next: (data: any) => {
        this.valoraciones = data;
        console.log('Datos Recibidos:', data);
      },
      error: (err) => {
        console.error('Error al obtener cafeterías:', err);
      }
    });
  }
}
