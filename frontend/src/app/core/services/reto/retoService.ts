import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Reto} from '@core/models/reto';
import {environment} from '../../../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class RetoService {
  constructor(private http: HttpClient) { }
  api = environment.apiUrl;

  getReto(): Observable<Reto[]> {
    let apiUrl= this.api + '/reto';
    return this.http.get<Reto[]>(apiUrl);
  }
}
