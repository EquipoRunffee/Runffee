import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Cupon} from '@shared/class/cupon';

@Injectable({
  providedIn: 'root',
})
export class CuponService {
  constructor(private http: HttpClient) { }

  getCupon(): Observable<Cupon[]> {
    let apiUrl= 'https://runffee.onrender.com/cupon';
    return this.http.get<Cupon[]>(apiUrl);
  }
}
