import { Component, OnInit, OnDestroy } from '@angular/core';
import { Apiprueba } from '@core/services/prueba/apiprueba';

@Component({
  selector: 'app-home',
  standalone: false,
  templateUrl: './home.html',
  styleUrls: ['./home.css'],
})
export class Home implements OnInit, OnDestroy {
  constructor(private api: Apiprueba) {}

  productos = [
    { img: './assets/images/merch/merch_cinturon.png', nombre: 'Cinturón' },
    { img: './assets/images/merch/merch_coffee.png', nombre: 'Café' },
    { img: './assets/images/merch/merch_gorra.png', nombre: 'Gorra' },
    { img: './assets/images/merch/merch_termo.png', nombre: 'Termo' },
    { img: './assets/images/merch/merch_tote.png', nombre: 'Tote Bag' },
    { img: './assets/images/merch/merch_vaso.png', nombre: 'Vaso' },
    { img: './assets/images/logo/LOGO_OSCURO.png', nombre: 'Runffee' },
  ];

  indiceActual = 0;
  private intervaloId: any;

  ngOnInit(): void {
    this.intervaloId = setInterval(() => {
      this.indiceActual = (this.indiceActual + 1) % this.productos.length;
    }, 800);
  }

  ngOnDestroy(): void {
    if (this.intervaloId) clearInterval(this.intervaloId);
  }
}
