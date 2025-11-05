import { Component, OnInit, OnDestroy } from '@angular/core';
import { Apiprueba } from '@core/services/apiprueba';

@Component({
  selector: 'app-home',
  standalone: false,
  templateUrl: './home.html',
  styleUrls: ['./home.css'],
})
export class Home implements OnInit, OnDestroy {
  constructor(private api: Apiprueba) {}

  productos = [
    { img: './assets/images/merch_cinturon.png', nombre: 'Cinturón' },
    { img: './assets/images/merch_coffee.png', nombre: 'Café' },
    { img: './assets/images/merch_gorra.png', nombre: 'Gorra' },
    { img: './assets/images/merch_termo.png', nombre: 'Termo' },
    { img: './assets/images/merch_tote.png', nombre: 'Tote Bag' },
    { img: './assets/images/merch_vaso.png', nombre: 'Vaso' },
    { img: './assets/images/LOGO_OSCURO.png', nombre: 'Runffee' },
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
