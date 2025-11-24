import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../../../environments/environment';
import {EntrenamientoDetalles} from '@core/models/entrenamientoDetalles';

@Injectable({
  providedIn: 'root',
})
export class EntrenamientoService {

  constructor(private http: HttpClient) { }
  api = environment.apiUrl;

  getEntrenamiento(): Observable<any> {
    let apiUrl= this.api + '/entrenamiento';
    return this.http.get<any>(apiUrl);
  }

  getEntrenamientoDetalles(id:number): Observable<EntrenamientoDetalles> {
    let apiUrl= this.api + '/entrenamiento/detalles/{id}';
    return this.http.get<EntrenamientoDetalles>(apiUrl);
  }
}
