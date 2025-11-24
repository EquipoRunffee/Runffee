import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ValoracionService {
  constructor(private http: HttpClient) { }
  api = environment.apiUrl;

  getValoracion(): Observable<any> {
    let apiUrl= this.api + '/valoracion';
    return this.http.get<any>(apiUrl);
  }
}
