import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../../../environments/environment';
import {Carrito} from '@core/models/carrito';

@Injectable({
  providedIn: 'root',
})
export class PedidoService {
  constructor(private http: HttpClient) { }
  api = environment.apiUrl;

  getPedido(): Observable<any> {
    let apiUrl= this.api + '/pedido';
    return this.http.get<any>(apiUrl);
  }

  crearPedido(carrito: any): Observable<any> {
    let apiUrl= this.api + '/pedido/crearpedido';
    return this.http.post<any>(apiUrl, carrito);
  }

  entregarPedido(idPedido: number): Observable<any> {
    let apiUrl= this.api + `/pedido/entregar/${idPedido}`;
    return this.http.get<any>(apiUrl);
  }
}
