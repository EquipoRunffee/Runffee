import { HttpClient } from "@angular/common/http";
import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import {environment} from '../../../../environments/environment';
import {adminProducto} from '@core/models/adminProducto';
import {adminCafeteria} from '@core/models/adminCafeteria';
import {adminReto} from '@core/models/adminReto';
import {adminEntrenamiento} from '@core/models/adminEntrenamiento';
import {adminUsuario} from '@core/models/adminUsuario';

@Injectable({
  providedIn: 'root',
})
export class AdminService {

  constructor(private http: HttpClient) {}
  api = environment.apiUrl;


  //GESTIÓN - PRODUCTOS

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


  //GESTIÓN - CAFETERIAS

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


  //GESTIÓN - RETO

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


  //GESTIÓN - ENTRENAMIENTOS

  obtenerEntrenamiento(id: number): Observable<adminEntrenamiento>{
    const url = `${this.api}/admin/entrenamiento/obtener/${id}`;
    return this.http.get<adminEntrenamiento>(url);
  }

  modificarEntrenamiento(id: number, entrenamiento: adminEntrenamiento): Observable<void> {
    const url = `${this.api}/admin/entrenamiento/modificar/${id}`;
    return this.http.put<void>(url, entrenamiento);
  }


  //GESTIÓN - USUARIOS

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
