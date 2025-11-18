import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {usuarioEncabezadoPerfil} from '@core/models/usuarioEncabezadoPerfil';
import {usuarioDatosPerfil} from '@core/models/usuarioDatosPerfil';

@Injectable({
  providedIn: 'root',
})
export class UsuarioService {
  constructor(private http: HttpClient) { }

  getUsuario(): Observable<any> {
    let apiUrl= 'https://runffee.onrender.com/usuario';
    return this.http.get<any>(apiUrl);
  }

  getEncabezadoPerfil(id: number): Observable<usuarioEncabezadoPerfil>{
    let apiUrl= 'https://runffee.onrender.com/usuario/encabezado_perfil/' + id.toString();
    return this.http.get<usuarioEncabezadoPerfil>(apiUrl);
  }

  getDatosPerfil(id:number): Observable<usuarioDatosPerfil>{
    let apiUrl= 'https://runffee.onrender.com/usuario/datos_perfil/' + id.toString();
    return this.http.get<usuarioDatosPerfil>(apiUrl);
  }
}
