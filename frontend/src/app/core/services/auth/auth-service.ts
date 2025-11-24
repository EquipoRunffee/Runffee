import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {tap} from 'rxjs';
import {environment} from '../../../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient) {}
  api = environment.apiUrl;

  login(credentials:{correo:string, contrasena:string}) {
    console.log("Realizando login...")
    return this.http.post<any>( this.api + "/auth/login", credentials)
      .pipe(
        tap(respuesta=>{
          localStorage.setItem("accessToken", respuesta.accessToken);
          localStorage.setItem("refreshToken", respuesta.refreshToken);
        })
      );
  }

  registrar(credentials:{correo:string, contrasena:string, stravaAccessToken: string|null}) {
    console.log("Registrando usuario...")
    return this.http.post<any>(this.api + "/auth/registrar", credentials)
      .pipe(
        tap(respuesta=>{
          localStorage.setItem("accessToken", respuesta.accessToken);
          localStorage.setItem("refreshToken", respuesta.refreshToken);
        })
      );
  }

  renovarToken(refreshToken: string) {
    return this.http.post<{ accessToken: string }>(
      this.api + "/auth/refresh",
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

  //Decodificar token para obtener el id del usuario registrado
  decodeToken(token: string | null): any {
    if (!token) return null;
    try {
      const payload = token.split('.')[1];
      return JSON.parse(atob(payload));
    } catch (error) {
      console.error("Error decodificando token:", error);
      return null;
    }
  }

  //Obtenemos el id del usuario registrado
  getUserId(): number | null {
    const token = this.getAccessToken();
    const decoded = this.decodeToken(token);

    if (!decoded || !decoded.sub) return null;

    return Number(decoded.sub);
  }
}
