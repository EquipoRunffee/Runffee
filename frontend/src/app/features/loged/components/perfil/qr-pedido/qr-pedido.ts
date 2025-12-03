import {Component, Input, OnInit} from '@angular/core';
import { QRCodeComponent } from 'angularx-qrcode';
import {environment} from '../../../../../../environments/environment';

@Component({
  selector: 'app-qr-pedido',
  standalone: true,
  templateUrl: './qr-pedido.html',
  styleUrl: './qr-pedido.css',
  imports: [
    QRCodeComponent
  ]
})
export class QrPedido implements OnInit {
  @Input() idPedido: number = 0;
  api = environment.apiUrl;
  qrData:string = "";
  ngOnInit() {
     this.qrData = this.api + '/pedido/recibido/' + this.idPedido.toString();
  }
}
