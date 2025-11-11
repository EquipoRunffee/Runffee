import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Cupon {
  constructor(private http: HttpClient) { }

  getCupon(): Observable<any> {
    let apiUrl= 'https://runffee.onrender.com/cupon';
    return this.http.get<any>(apiUrl);
  }
}
