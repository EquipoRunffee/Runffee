import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Cafeteria} from '@core/models/cafeteria';
import {environment} from '../../../../environments/environment';


@Injectable({
  providedIn: 'root',
})
export class CafeteriaService {
  constructor(private http: HttpClient) { }
  api = environment.apiUrl;

  getCafeteria(): Observable<Cafeteria[]> {
    let apiUrl= this.api + '/cafeteria';
      return this.http.get<Cafeteria[]>(apiUrl);
    }
}
