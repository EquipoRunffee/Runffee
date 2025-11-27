import {Component, OnInit} from '@angular/core';
import {RouterModule} from '@angular/router';
import {ValoracionCard} from '@shared/components/valoracion-card/valoracion-card';
import {ValoracionService} from '@core/services/valoracion/valoracionesService';
import {NgForOf} from '@angular/common';
import {Valoraciones} from '@core/models/valoraciones';

@Component({
  selector: 'app-valoraciones',
  imports: [RouterModule, ValoracionCard, NgForOf],
  templateUrl: './valoraciones.html',
  styleUrls: ['./valoraciones.css'],
})
export class ValoracionesComponent implements OnInit {
  valoraciones: Valoraciones[] = [];

  constructor(private valoracionService: ValoracionService) {}

  ngOnInit(): void {
    this.cargarValoraciones();
  }

  cargarValoraciones(): void {
    this.valoracionService.getValoracion().subscribe({
      next: (data: any) => {
        // Cargamos datos
        this.valoraciones = data;
        console.log('Datos Recibidos:', data);
      },
      error: (err) => {
        console.error('Error al obtener valoraciones:', err);
      }
    });
  }
}
