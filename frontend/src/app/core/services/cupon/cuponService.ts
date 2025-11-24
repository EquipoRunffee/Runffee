import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Cupon} from '@core/models/cupon';
import {environment} from '../../../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class CuponService {
  constructor(private http: HttpClient) { }

  getCupon(): Observable<Cupon[]> {
    const api = environment.apiUrl;
    let apiUrl= api + '/cupon';
    return this.http.get<Cupon[]>(apiUrl);
  }
}
