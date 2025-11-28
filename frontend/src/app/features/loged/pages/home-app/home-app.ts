import {Component, ViewChild, ElementRef, OnInit} from '@angular/core';
import { CafeteriaCard } from '@shared/components/cafeteriaCard/cafeteriaCard';
import {CardReto} from '@loged/components/card-reto/card-reto';
import {Footer} from '@shared/components/footer/footer';
import {Navbar} from '@loged/components/navbar/navbar';
import {RetoService} from '@core/services/reto/retoService';
import {Reto} from '@core/models/reto';
import {CarritoService} from '@core/services/carrito/carritoService';
import {Carrito} from '@core/models/carrito';

@Component({
  selector: 'app-home-app',
  standalone: true,
  templateUrl: './home-app.html',
  styleUrls: ['./home-app.css'],
  imports: [CafeteriaCard, CardReto, Footer, Navbar]
})
export class HomeApp implements OnInit {
  mes = new Date().toLocaleString('es-ES', { month: 'long' });
  selectedIndexReto: number | null = null;
  popUp: HTMLElement | null = null;
  @ViewChild(CafeteriaCard) contenedor!: CafeteriaCard;
  retos: Reto[] | null = null;

  constructor(private retoService: RetoService, private carritoService: CarritoService ) {}

  ngOnInit() {

    this.retoService.getReto().subscribe({
      next: data => {
        this.retos = data;
      },
      error: err => {
        console.log(err);
      }
    })
  }

  onSelectedReto(i: number) {
    if (this.selectedIndexReto === i) {
      this.selectedIndexReto = null;
    } else {
      this.selectedIndexReto = i;
      this.contenedor.scrollTo();
    }
    this.carritoService.setIdReto(this.selectedIndexReto)
  }

  actualizarPopUp(){
    this.popUp = document.getElementById("popup-objetivo");
    if(this.popUp){
      if(this.popUp.style.display === 'flex'){
        this.popUp.style.display = 'none';
      } else {
        this.popUp.style.display = 'flex';
      }
    }
  }

}
