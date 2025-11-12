import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class StravaService {
  conexionStrava(){
    const clientId = '182872';
    //URL donde queremos que se le redirige al usuario cuando haya iniciado sesión con Strava
    const redirectUri = 'http://localhost:4200/callback';
    const scope = 'read,activity:read_all';
    const url = `https://www.strava.com/oauth/authorize?client_id=${clientId}` +
      `&redirect_uri=${encodeURIComponent(redirectUri)}` +
      `&response_type=code` +
      `&scope=read,activity:read_all` +
      `&approval_prompt=auto`;
    window.location.href = url;
  }
}
