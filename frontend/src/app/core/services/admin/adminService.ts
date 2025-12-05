import { HttpClient } from "@angular/common/http";
import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import {environment} from '../../../../environments/environment';
import {adminProducto} from '@core/models/adminProducto';

@Injectable({
  providedIn: 'root',
})
export class AdminService {

  constructor(private http: HttpClient) {}
  api = environment.apiUrl;

  crearProducto(producto: adminProducto): Observable<void> {
    console.log(producto);
    const url = `${this.api}/admin/producto/crear`;
    return this.http.post<void>(url, producto);
  }

  obtenerProducto(id: number): Observable<adminProducto> {
    const url = `${this.api}/admin/producto/modificar/${id}`;
    return this.http.get<adminProducto>(url);
  }

  modificarProducto(id: number, producto: adminProducto): Observable<void> {
    const url = `${this.api}/admin/producto/modificar/${id}`;
    return this.http.put<void>(url, producto);
  }

  eliminarProducto(id: number): Observable<void> {
    const url = `${this.api}/admin/producto/eliminar/${id}`;
    return this.http.delete<void>(url);
  }
}
