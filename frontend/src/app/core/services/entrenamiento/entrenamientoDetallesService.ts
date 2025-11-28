import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {EntrenamientoDetalles} from '@core/models/entrenamientoDetalles';
import {HttpClient} from '@angular/common/http';
import {Valoraciones} from '@core/models/valoraciones';
import {Entrenamientos} from '@loged/components/perfil/entrenamientos/entrenamientos';
import {environment} from '../../../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class EntrenamientoDetallesService {
  constructor(private http: HttpClient) { }
  api = environment.apiUrl;

  getEntrenamientoDetalle(): Observable<EntrenamientoDetalles[]> {
    let apiUrl= this.api + '/entrenamiento/detalles';
    return this.http.get<EntrenamientoDetalles[]>(apiUrl);
  }
}
