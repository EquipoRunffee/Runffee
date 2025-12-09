import {Component, OnInit} from '@angular/core';
import {Router, RouterLink} from '@angular/router';
import {CarritoService} from '@core/services/carrito/carritoService';
import {DecimalPipe} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {CuponService} from '@core/services/cupon/cuponService';
import {PedidoService} from '@core/services/pedido/pedidoService';

@Component({
  selector: 'app-pago',
  standalone: true,
  templateUrl: './pago.html',
  styleUrl: './pago.css',
  imports: [
    RouterLink,
    DecimalPipe,
    FormsModule
  ]
})
export class Pago implements OnInit {
  popUp: HTMLElement | null = null;
  productos: any;
  cuponAplicadoEstado: boolean = false;
  descuentoAplicado:number = 5;
  nombreCupon: string = "";
  regalo: any = null;

  mensajeCuponAplicadoEstado: boolean = false;
  mensajeCuponAplicado:string = "";

  popUpConfirmacionEstado: boolean = false;

  mostrarMensajesEstado:boolean = false;
  textoMensajes:string = "";

  constructor(public router: Router,
              private carritoService: CarritoService,
              private cuponService: CuponService,
              private pedidoService: PedidoService,) {}

  ngOnInit() {
    this.productos = this.carritoService.getCarrito().productosCarrito;
  }

  calcularSubtotal(){
    let subtotal = 0.00;
    for (let i = 0; i < this.productos.length; i++) {
      subtotal += this.productos[i].precio * this.productos[i].cantidad;
    }
    return subtotal;
  }

  calcularTotal(){
    const subtotal = this.calcularSubtotal();
    const total = subtotal * (1 - this.descuentoAplicado / 100);
    return parseFloat(total.toFixed(2));
  }

  consultarCupon(){
    this.mensajeCuponAplicadoEstado = false;
    if(this.nombreCupon != ""){
      this.cuponService.getCuponCarrito(this.nombreCupon).subscribe({
        next: data => {
          console.log(data);
          this.mensajeCuponAplicado = "¡Cupón aplicado!";
          this.mensajeCuponAplicadoEstado = true;
          this.carritoService.setNombreCupon(this.nombreCupon);

          if(data.tipo == "DESCUENTO"){
            this.descuentoAplicado = data.porcentaje;
          }else{
            this.regalo = data;
          }
        },
        error: error => {
          this.mensajeCuponAplicado = error;
          this.mensajeCuponAplicadoEstado = true;
          this.regalo = null;
          this.descuentoAplicado = 5;
          this.carritoService.setNombreCupon(null);
        }
      })
    }
  }

  eliminarCupon(){
    this.descuentoAplicado = 5;
    this.regalo = null;
    this.mensajeCuponAplicadoEstado = false;
    this.carritoService.setNombreCupon(null);
  }

  verificarNumeroTarjeta(event: any) {
    const input = event.target as HTMLInputElement;
    let valor = input.value.replace(/\D/g, '');
    if (valor.length > 16) {
      valor = valor.slice(0, 16);
    }
    valor = valor.replace(/(.{4})/g, '$1 ').trim();
    input.value = valor;
  }

  verificarCVV(event: any) {
    const input = event.target as HTMLInputElement;
    input.value = input.value.replace(/[^0-9]/g, '');

    if (input.value.length > 3) {
      input.value = input.value.slice(0, 3);
    }
  }

  validarMes(event: any) {
    const input = event.target as HTMLInputElement;
    let valor = input.value.replace(/\D/g, '');
    if (valor.length > 2) {
      valor = valor.slice(0, 2);
    }
    if (parseInt(valor, 10) > 12) {
      valor = '12';
    }
    input.value = valor;
  }

  validarAno(event: any) {
    const input = event.target as HTMLInputElement;
    let valor = input.value.replace(/\D/g, '');
    if (valor.length > 4) {
      valor = valor.slice(0, 4);
    }
    input.value = valor;
  }

  realizarPago(){
    this.pedidoService.crearPedido(this.carritoService.getCarrito()).subscribe({
      next: data => {
        if(data.status == "done"){
          this.popUpConfirmacionEstado = true;
        } else {
          this.mostrarMensajes(data.texto);
        }
      },
      error: error => {
        console.log(error);
      }
    })
  }

  mostrarMensajes(mensaje: string):void{
    this.mostrarMensajesEstado = true;
    this.textoMensajes = mensaje;
    setTimeout(() => {
      this.mostrarMensajesEstado = false;
    }, 3000)
  }
}
