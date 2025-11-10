import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class LineaPedidoService {


  constructor(private http: HttpClient) { }

  getLineaPedido(): Observable<any> {
    let apiUrl= 'https://runffee.onrender.com/lineapedido';
    return this.http.get<any>(apiUrl);
  }

  getLineaPedidoEliminados(): Observable<any> {
    let apiUrl= 'https://runffee.onrender.com/lineapedido\sdfsdf';
    return this.http.get<any>(apiUrl);
  }
}
