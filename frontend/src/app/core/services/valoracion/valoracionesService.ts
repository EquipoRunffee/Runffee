import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Valoraciones} from '@core/models/valoraciones';
import {environment} from '../../../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ValoracionService {
  constructor(private http: HttpClient) { }
  api = environment.apiUrl;

  getValoracion(): Observable<Valoraciones[]> {
    let apiUrl= this.api + '/valoracion/valoracionesusuario';
    return this.http.get<Valoraciones[]>(apiUrl);
  }
}
