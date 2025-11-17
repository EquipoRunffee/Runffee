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
    return this.http.post<any>("https://onrender.runffee.com/auth/login", credentials)
      .pipe(
        tap(respuesta=>{
          localStorage.setItem("accessToken", respuesta.accessToken);
        })
      );
  }

  registrar(credentials:{correo:string, contrasena:string, stravaAccessToken: string|null}) {
    console.log("Registrando usuario...")
    return this.http.post<any>("https://onrender.runffee.com/auth/registrar", credentials)
      .pipe(
        tap(respuesta=>{
          console.log(respuesta);
          localStorage.setItem("accessToken", respuesta.accessToken);
        })
      );
  }

  logout(){
    localStorage.removeItem("accessToken");
  }

  isLogged():boolean{
    const accessToken = localStorage.getItem("accessToken");
    return !!accessToken;
  }

  getAccessToken(){
    return localStorage.getItem("accessToken");
  }
}
