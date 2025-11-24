import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class LineaPedidoService {


  constructor(private http: HttpClient) { }
  api = environment.apiUrl;

  getLineaPedido(): Observable<any> {
    let apiUrl= this.api + '/lineapedido';
    return this.http.get<any>(apiUrl);
  }

  getLineaPedidoEliminados(): Observable<any> {
    let apiUrl= this.api + '/lineapedido/eliminar{id}';
    return this.http.get<any>(apiUrl);
  }
}
