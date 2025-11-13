import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Apiprueba {
  private apiUrl = 'https://runffee.onrender.com/prueba';

  constructor(private http: HttpClient) { }

  getPrueba(): Observable<any> {
    return this.http.get<any>(this.apiUrl);
  }
}
