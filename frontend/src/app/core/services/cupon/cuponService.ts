import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Cupon} from '@core/models/any';
import {environment} from '../../../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class CuponService {
  constructor(private http: HttpClient) { }

  getCupon(): Observable<any> {
    const api = environment.apiUrl;
    let apiUrl= api + '/cupon/cuponesusuario';
    return this.http.get<any>(apiUrl);
  }

  getCuponCarrito(nombreCupon: string): Observable<any>{
    const api = environment.apiUrl;
    let apiUrl= api + '/cupon/cuponcarrito/' + nombreCupon;
    return this.http.get<any>(apiUrl);
  }
}
