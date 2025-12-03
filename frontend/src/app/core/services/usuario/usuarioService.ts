import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
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

  getDatosPerfil(): Observable<usuarioDatosPerfil>{
    let apiUrl= this.api + '/usuario/datos_perfil';
    return this.http.get<usuarioDatosPerfil>(apiUrl);
  }

  getFotoUsuario(): Observable<any>{
    let apiUrl= this.api + '/usuario/foto';
    return this.http.get<any>(apiUrl);
  }

  setCambioContrasena(datos: Object): Observable<string> {
    const apiUrl = this.api + '/usuario/cambiarContrasena';
    return this.http.post(apiUrl, datos, { responseType: 'text' });
  }
}
