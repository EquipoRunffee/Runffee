import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {entrenamientoDetalles} from '@core/models/entrenamientoDetalles';

@Injectable({
  providedIn: 'root',
})
export class EntrenamientoService {

  constructor(private http: HttpClient) { }

  getEntrenamiento(): Observable<any> {
    let apiUrl= 'https://runffee.onrender.com/entrenamiento';
    return this.http.get<any>(apiUrl);
  }

  getEntrenamientoDetalles(id:number): Observable<entrenamientoDetalles> {
    let apiUrl= 'https://runffee.onrender.com/entrenamiento/detalles/{id}';
    return this.http.get<entrenamientoDetalles>(apiUrl);
  }
}
