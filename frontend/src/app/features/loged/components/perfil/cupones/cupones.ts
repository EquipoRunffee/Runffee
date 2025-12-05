import {Component, OnInit} from '@angular/core';
import {Router, RouterModule} from '@angular/router';
import {Cupon} from '@loged/components/cupon/cupon';
import {CuponService} from '@core/services/cupon/cuponService';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-cupones',
  imports: [RouterModule, Cupon, CommonModule],
  templateUrl: './cupones.html',
  styleUrl: './cupones.css',
  standalone: true,
})
export class Cupones implements OnInit {
  cupones: any;
  ahora = new Date();
  activo = true;
  cuponesCargados:boolean = false;

  constructor(private cuponService: CuponService) {}

  ngOnInit(): void {
    this.cargarCupones();
  }

  cargarCupones(): void {
      this.cuponService.getCupon().subscribe({
        next: (data: any) => {
          this.cuponesCargados = true;
          this.cupones = data;
          console.log('Datos Recibidos:', data);
        },
        error: (error: any) => {
          console.error('Error al cupones creado', error);
        }
      })
  }

  cambiarEstado(nuevoEstado: boolean): void{
    this.activo = nuevoEstado;
  }
}
