import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Reto {
  constructor(private http: HttpClient) { }

  getReto(): Observable<any> {
    let apiUrl= 'https://runffee.onrender.com/reto';
    return this.http.get<any>(apiUrl);
  }
}
