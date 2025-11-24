import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {entrenamientoDetalles} from '@core/models/entrenamientoDetalles';
import {environment} from '../../../../environments/environment';

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

  getEntrenamientoDetalles(id:number): Observable<entrenamientoDetalles> {
    let apiUrl= this.api + '/entrenamiento/detalles/{id}';
    return this.http.get<entrenamientoDetalles>(apiUrl);
  }
}
