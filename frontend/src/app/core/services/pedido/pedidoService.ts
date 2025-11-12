import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PedidoService {
  constructor(private http: HttpClient) { }

  getPedido(): Observable<any> {
    let apiUrl= 'https://runffee.onrender.com/pedido';
    return this.http.get<any>(apiUrl);
  }
}
