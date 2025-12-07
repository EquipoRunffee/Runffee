import { HttpClient } from "@angular/common/http";
import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import {environment} from '../../../../environments/environment';
import {adminProducto} from '@core/models/adminProducto';
import {adminCafeteria} from '@core/models/adminCafeteria';
import {adminReto} from '@core/models/adminReto';
import {adminEntrenamiento} from '@core/models/adminEntrenamiento';


@Injectable({
  providedIn: 'root',
})
export class AdminService {

  constructor(private http: HttpClient) {}
  api = environment.apiUrl;

  crearProducto(producto: adminProducto): Observable<void> {
    const url = `${this.api}/admin/producto/crear`;
    return this.http.post<void>(url, producto);
  }

  obtenerProducto(id: number): Observable<adminProducto> {
    const url = `${this.api}/admin/producto/obtener/${id}`;
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

  crearCafeteria(cafeteria: adminCafeteria): Observable<void>{
    const url = `${this.api}/admin/cafeteria/crear`;
    return this.http.post<void>(url, cafeteria);
  }

  obtenerCafeteria(id: number): Observable<adminCafeteria>{
    const url = `${this.api}/admin/cafeteria/obtener/${id}`;
    return this.http.get<adminCafeteria>(url);
  }

  modificarCafeteria(id: number, cafeteria: adminCafeteria): Observable<void> {
    const url = `${this.api}/admin/cafeteria/modificar/${id}`;
    return this.http.put<void>(url, cafeteria);
  }

  eliminarCafeteria(id: number): Observable<void> {
    const url = `${this.api}/admin/cafeteria/eliminar/${id}`;
    return this.http.delete<void>(url);
  }

  crearReto(reto: adminReto): Observable<void>{
    const url = `${this.api}/admin/reto/crear`;
    return this.http.post<void>(url, reto);
  }

  obtenerReto(id: number): Observable<adminReto>{
    const url = `${this.api}/admin/reto/obtener/${id}`;
    return this.http.get<adminReto>(url);
  }

  modificarReto(id: number, reto: adminReto): Observable<void> {
    const url = `${this.api}/admin/reto/modificar/${id}`;
    return this.http.put<void>(url, reto);
  }

  eliminarReto(id: number): Observable<void> {
    const url = `${this.api}/admin/reto/eliminar/${id}`;
    return this.http.delete<void>(url);
  }

  obtenerEntrenamiento(id: number): Observable<adminEntrenamiento>{
    const url = `${this.api}/admin/entrenamiento/obtener/${id}`;
    return this.http.get<adminEntrenamiento>(url);
  }

  modificarEntrenamiento(id: number, entrenamiento: adminEntrenamiento): Observable<void> {
    const url = `${this.api}/admin/entrenamiento/modificar/${id}`;
    return this.http.put<void>(url, entrenamiento);
  }


}
