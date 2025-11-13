import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Reto} from '@core/models/reto';

@Injectable({
  providedIn: 'root',
})
export class RetoService {
  constructor(private http: HttpClient) { }

  getReto(): Observable<Reto[]> {
    let apiUrl= 'https://runffee.onrender.com/reto';
    return this.http.get<Reto[]>(apiUrl);
  }
}
