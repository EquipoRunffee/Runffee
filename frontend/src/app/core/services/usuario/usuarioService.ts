import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {UsuarioEncabezadoPerfil} from '@core/models/UsuarioEncabezadoPerfil';

@Injectable({
  providedIn: 'root',
})
export class UsuarioService {
  constructor(private http: HttpClient) { }

  getUsuario(): Observable<any> {
    let apiUrl= 'https://runffee.onrender.com/usuario';
    return this.http.get<any>(apiUrl);
  }

  getEncabezadoPerfil(id: number): Observable<UsuarioEncabezadoPerfil>{
    let apiUrl= 'https://runffee.onrender.com/usuario/encabezado_perfil/' + id.toString();
    return this.http.get<UsuarioEncabezadoPerfil>(apiUrl);
}
}
