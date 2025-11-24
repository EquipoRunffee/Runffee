import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {usuarioEncabezadoPerfil} from '@core/models/usuarioEncabezadoPerfil';
import {usuarioDatosPerfil} from '@core/models/usuarioDatosPerfil';
import {environment} from '../../../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class UsuarioService {
  constructor(private http: HttpClient) { }
  api = environment.apiUrl;


  getUsuario(): Observable<any> {
    let apiUrl= this.api + '/usuario';
    return this.http.get<any>(apiUrl);
  }

  getEncabezadoPerfil(id: number): Observable<usuarioEncabezadoPerfil>{
    let apiUrl= this.api + '/usuario/encabezado_perfil/' + id.toString();
    return this.http.get<usuarioEncabezadoPerfil>(apiUrl);
  }

  getDatosPerfil(id:number): Observable<usuarioDatosPerfil>{
    let apiUrl= this.api + '/usuario/datos_perfil/' + id.toString();
    return this.http.get<usuarioDatosPerfil>(apiUrl);
  }
}
