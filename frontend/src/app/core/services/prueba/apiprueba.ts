import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class Apiprueba {
  api = environment.apiUrl;
  private apiUrl = this.api + '/prueba';

  constructor(private http: HttpClient) { }

  getPrueba(): Observable<any> {
    return this.http.get<any>(this.apiUrl);
  }
}
