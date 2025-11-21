import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
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

  getDatosPerfil(): Observable<usuarioDatosPerfil>{
    let apiUrl= 'https://runffee.onrender.com/usuario/datos_perfil';
    return this.http.get<usuarioDatosPerfil>(apiUrl);
  }
}
