import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CuponService {
  private apiUrl = 'https://runffee.onrender.com/cupon';

  constructor(private http: HttpClient) { }

  getCupon(): Observable<any> {
    return this.http.get<any>(this.apiUrl);
  }
}
