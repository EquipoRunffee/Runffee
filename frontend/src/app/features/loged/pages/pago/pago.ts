import { Component } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-pago',
  standalone: true,
  templateUrl: './pago.html',
  styleUrl: './pago.css',
})
export class Pago {
  popUp: HTMLElement | null = null;

  constructor(public router: Router) {}

  verificarNumeroTarjeta(event: any) {
    const input = event.target as HTMLInputElement;
    input.value = input.value.replace(/[^0-9]/g, '');

    if (input.value.length > 16) {
      input.value = input.value.slice(0, 16);
    }
  }

  verificarCVV(event: any) {
    const input = event.target as HTMLInputElement;
    input.value = input.value.replace(/[^0-9]/g, '');

    if (input.value.length > 3) {
      input.value = input.value.slice(0, 3);
    }
  }

  verpopUp(){
    this.popUp = document.getElementById("popUp");
    if(this.popUp){
      if(this.popUp.style.display === 'flex'){
        this.popUp.style.display = 'none';
      } else {
        this.popUp.style.display = 'flex';
      }
    }
  }
}
