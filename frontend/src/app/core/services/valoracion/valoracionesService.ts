import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Valoraciones} from '@core/models/valoraciones';

@Injectable({
  providedIn: 'root',
})
export class ValoracionesService {
  constructor(private http: HttpClient) { }

  getValoracion(): Observable<Valoraciones[]> {
    let apiUrl= 'https://runffee.onrender.com/valoracion';
    return this.http.get<Valoraciones[]>(apiUrl);
  }
}
