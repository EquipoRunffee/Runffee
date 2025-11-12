import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Cafeteria} from '@shared/class/cafeteria';


@Injectable({
  providedIn: 'root',
})
export class CafeteriaService {
  constructor(private http: HttpClient) { }

  getCafeteria(): Observable<Cafeteria[]> {
    let apiUrl= 'https://runffee.onrender.com/cafeteria';
      return this.http.get<Cafeteria[]>(apiUrl);
    }
}
