import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ProductoService {
  constructor(private http: HttpClient) { }
  api = environment.apiUrl;

  getProducto(): Observable<any> {
    let apiUrl= this.api + '/producto';
    return this.http.get<any>(apiUrl);
  }
}
