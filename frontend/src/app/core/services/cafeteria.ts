import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Cafeteria {
  constructor(private http: HttpClient) { }

  getCafeteria(): Observable<any[]> {
    let apiUrl= 'https://runffee.onrender.com/cafeteria';
      return this.http.get<Cafeteria[]>(apiUrl);
    }
}
