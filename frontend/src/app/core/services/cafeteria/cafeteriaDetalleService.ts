import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CafeteriaDetalle} from '@core/models/cafeteria-detalle';

@Injectable({
  providedIn: 'root',
})
export class CafeteriaDetalleService {
  constructor(private http: HttpClient) { }

  getCafeteriaDetalle(): Observable<CafeteriaDetalle[]> {
    let apiUrl= 'https://runffee.onrender.com/cafeteria/detalle';
    return this.http.get<CafeteriaDetalle[]>(apiUrl);
  }
}
