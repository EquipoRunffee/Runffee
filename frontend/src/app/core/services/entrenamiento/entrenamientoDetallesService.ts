import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {EntrenamientoDetalles} from '@core/models/entrenamientoDetalles';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class EntrenamientoDetallesService {
  constructor(private http: HttpClient) { }

  getEntrenamientoDetalle(): Observable<EntrenamientoDetalles[]> {
    let apiUrl= 'https://runffee.onrender.com/entrenamiento/detalles';
    return this.http.get<EntrenamientoDetalles[]>(apiUrl);
  }
}
