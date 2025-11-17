import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {tap} from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient) {}

  login(credentials:{correo:string, contrasena:string}) {
    return this.http.post<any>("https://onrender.runffee.com/auth/login", credentials)
      .pipe(
        tap(respuesta=>{
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
