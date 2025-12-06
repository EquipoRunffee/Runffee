import { HttpClient } from "@angular/common/http";
import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import {environment} from '../../../../environments/environment';
import {adminProducto} from '@core/models/adminProducto';
import {adminUsuario} from '@core/models/adminUsuario';

@Injectable({
  providedIn: 'root',
})
export class AdminService {

  constructor(private http: HttpClient) {}
  api = environment.apiUrl;

  //Crear un producto
  crearProducto(producto: adminProducto): Observable<void> {
    const url = `${this.api}/admin/producto/crear`;
    return this.http.post<void>(url, producto);
  }

  //Obtener datos de un producto por su id
  obtenerProducto(id: number): Observable<adminProducto> {
    const url = `${this.api}/admin/producto/obtener/${id}`;
    return this.http.get<adminProducto>(url);
  }

  //Modificar datos de un producto
  modificarProducto(id: number, producto: adminProducto): Observable<void> {
    const url = `${this.api}/admin/producto/modificar/${id}`;
    return this.http.put<void>(url, producto);
  }

  //Eliminar un producto por su id
  eliminarProducto(id: number): Observable<void> {
    const url = `${this.api}/admin/producto/eliminar/${id}`;
    return this.http.delete<void>(url);
  }

  //Obtener datos de un usuario por su id
  obtenerUsuario(id:number): Observable<adminUsuario> {
    const url = `${this.api}/admin/usuario/obtener/${id}`;
    return this.http.get<adminUsuario>(url);
  }

  //Modificar datos de un usuario
  modificarUsuario(id: number, usuario: adminUsuario): Observable<void> {
    const url = `${this.api}/admin/usuario/modificar/${id}`;
    return this.http.put<void>(url, usuario);
  }

  //Eliminar un usuario por su id
  eliminarUsuario(id: number): Observable<void> {
    const url = `${this.api}/admin/usuario/eliminar/${id}`;
    return this.http.delete<void>(url);
  }
}
