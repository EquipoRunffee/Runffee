import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {tap} from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient) {}

  login(credentials:{correo:string, contrasena:string}) {
    console.log("Realizando login...")
    return this.http.post<any>("https://runffee.onrender.com/auth/login", credentials)
      .pipe(
        tap(respuesta=>{
          localStorage.setItem("accessToken", respuesta.accessToken);
          localStorage.setItem("refreshToken", respuesta.refreshToken);
        })
      );
  }

  registrar(credentials:{correo:string, contrasena:string, stravaAccessToken: string|null}) {
    console.log("Registrando usuario...")
    return this.http.post<any>("https://runffee.onrender.com/auth/registrar", credentials)
      .pipe(
        tap(respuesta=>{
          localStorage.setItem("accessToken", respuesta.accessToken);
          localStorage.setItem("refreshToken", respuesta.refreshToken);
        })
      );
  }

  renovarToken(refreshToken: string) {
    return this.http.post<{ accessToken: string }>(
      'https://runffee.onrender.com/auth/refresh',
      { refreshToken }
    );
  }

  logout(){
    localStorage.removeItem("accessToken");
    localStorage.removeItem("refreshToken");
  }

  isLogged():boolean{
    const accessToken = localStorage.getItem("accessToken");
    return !!accessToken;
  }

  getAccessToken(){
    return localStorage.getItem("accessToken");
  }

  setAccessToken(accessToken: string){
    localStorage.setItem("accessToken", accessToken);
  }

  getRefreshToken(){
    return localStorage.getItem("refreshToken");
  }

  setRefreshToken(refreshToken: string){
    localStorage.setItem("refreshToken", refreshToken);
  }


}
