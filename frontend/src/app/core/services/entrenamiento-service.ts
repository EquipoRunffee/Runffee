import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class EntrenamientoService {
  private apiUrl = 'https://runffee.onrender.com/entrenamiento';

  constructor(private http: HttpClient) { }

  getEntrenamiento(): Observable<any> {
    return this.http.get<any>(this.apiUrl);
  }
}
