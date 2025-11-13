import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class StravaService {

  /*
  * Función para redirigir al usuario a la pagina de Inicio de Sesión de Strava
  * */
  conexionStrava(){

    //Este codigo es el de nuestra app de strava
    const clientId = '182872';

    //URL donde queremos que se le redirige al usuario cuando haya iniciado sesión con Strava
    const redirectUri = 'http://localhost:4200/callback';

    //Construimos la url entera
    const url = `https://www.strava.com/oauth/authorize?client_id=${clientId}` +
      `&redirect_uri=${encodeURIComponent(redirectUri)}` +
      `&response_type=code` +
      `&scope=read,activity:read_all` +
      `&approval_prompt=auto`;

    //Redirigimos al usuario a la URL
    window.location.href = url;
  }
}
