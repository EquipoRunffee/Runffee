import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map, Observable} from 'rxjs';
import {CafeteriaDetalles} from '@core/models/cafeteria-detalles';

@Injectable({
  providedIn: 'root',
})
export class CafeteriaDetallesService {
  constructor(private http: HttpClient) { }

  getCafeteriaDetalle(): Observable<CafeteriaDetalles[]> {
    let apiUrl= 'https://runffee.onrender.com/cafeteria/detalles';
    return this.http.get<CafeteriaDetalles[]>(apiUrl);
  }
}
