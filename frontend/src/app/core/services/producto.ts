import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Producto {
  constructor(private http: HttpClient) { }

  getProducto(): Observable<any> {
    let apiUrl= 'https://runffee.onrender.com/producto';
    return this.http.get<any>(apiUrl);
  }
}
