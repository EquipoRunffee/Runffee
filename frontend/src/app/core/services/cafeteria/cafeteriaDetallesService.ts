import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CafeteriaDetalles} from '@core/models/cafeteria-detalles';
import {environment} from '../../../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class CafeteriaDetallesService {
  constructor(private http: HttpClient) { }
  api = environment.apiUrl;


  getCafeteriaDetalle(): Observable<CafeteriaDetalles[]> {
    let apiUrl= this.api + '/cafeteria/detalles';
    return this.http.get<CafeteriaDetalles[]>(apiUrl);
  }
}
