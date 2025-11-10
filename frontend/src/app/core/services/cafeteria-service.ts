import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CafeteriaService {
  private apiUrl = 'https://runffee.onrender.com/cafeteria';

  constructor(private http: HttpClient) { }

  getCafeteria(): Observable<any> {
    return this.http.get<any>(this.apiUrl);
  }
}
