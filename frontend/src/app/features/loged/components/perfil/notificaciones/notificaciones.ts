import { Component } from '@angular/core';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-notificaciones',
  imports: [RouterModule, FormsModule],
  templateUrl: './notificaciones.html',
  styleUrls: ['./notificaciones.css'],
})
export class Notificaciones {

  //Lista de notificaciones
  notificaciones = [
    {
      categoria: 'Actividad y Retos',
      items: [
        { texto: 'Notificar cuando un reto está completado', activado: false },
        { texto: 'Recordatorios de retos pendientes', activado: false },
        { texto: 'Aviso de reto expirado o no completado', activado: false }
      ]
    },
    {
      categoria: 'Pedidos y recompensas',
      items: [
        { texto: 'Confirmación de compra', activado: false },
        { texto: 'Cambio de estado del pedido', activado: false }
      ]
    },
    {
      categoria: 'Ubicación y cafeterías',
      items: [
        { texto: 'Nuevas cafeterías asociadas cercanas', activado: false },
        { texto: 'Ofertas o promociones exclusivas', activado: false },
        { texto: 'Eventos o retos especiales', activado: false }
      ]
    }
  ];

  //Metodo opcional
  toggleItem(item: any) {
    item.activado = !item.activado;
    console.log(`${item.texto}: ${item.activado ? 'Activado' : 'Desactivado'}`);
  }

}
