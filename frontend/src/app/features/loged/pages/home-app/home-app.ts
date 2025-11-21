import { Component, ViewChild, ElementRef } from '@angular/core';
import { CafeteriaCard } from '@shared/components/cafeteriaCard/cafeteriaCard';
import {CardReto} from '@loged/components/card-reto/card-reto';
import {Footer} from '@shared/components/footer/footer';
import {Navbar} from '@loged/components/navbar/navbar';

@Component({
  selector: 'app-home-app',
  standalone: true,
  templateUrl: './home-app.html',
  styleUrls: ['./home-app.css'],
  imports: [CafeteriaCard, CardReto, Footer, Navbar]
})
export class HomeApp{
  mes = new Date().toLocaleString('es-ES', { month: 'long' });
  cards = [1,2,3,4,5]
  selectedIndex: number | null = null;
  popUp: HTMLElement | null = null;
  @ViewChild(CafeteriaCard) contenedor!: CafeteriaCard;

  onSelected(i: number) {
    if (this.selectedIndex === i) {
      this.selectedIndex = null;
    } else {
      this.selectedIndex = i;
      this.contenedor.scrollTo();
    }
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
