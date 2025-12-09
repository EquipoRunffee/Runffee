import {Component, ElementRef, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
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

  @Output() deslizado = new EventEmitter<void>();

  @ViewChild('slider') slider!: ElementRef;
  @ViewChild('handle') handle!: ElementRef;

  dragging = false;

  startDrag(event: MouseEvent) {
    this.dragging = true;

    window.onmouseup = () => this.dragging = false;

    window.onmousemove = (e) => {
      if (!this.dragging) return;

      const sliderRect = this.slider.nativeElement.getBoundingClientRect();

      let x = e.clientX - sliderRect.left - 25; // handle center

      // límites
      if (x < 0) x = 0;
      if (x > sliderRect.width - 50) x = sliderRect.width - 50;

      this.handle.nativeElement.style.left = x + 'px';

      // si llegó al final → emitir evento
      if (x >= sliderRect.width - 50) {
        this.dragging = false;
        this.deslizado.emit();
      }
    };
  }
}
