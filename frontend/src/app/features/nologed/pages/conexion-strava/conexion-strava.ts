import {Component, Injectable} from '@angular/core';

@Component({
  selector: 'app-conexion-strava',
  standalone: false,
  templateUrl: './conexion-strava.html',
  styleUrl: './conexion-strava.css',
})

@Injectable({ providedIn: 'root' })
export class ConexionStrava {
  private clientId = '182872';
  private redirectUri = 'http://localhost:4200/strava/callback';
  private scope = 'read,activity:read_all';

  connectWithStrava() {
    const url = `https://www.strava.com/oauth/authorize?client_id=${this.clientId}
    &redirect_uri=${this.redirectUri}
    &response_type=code
    &scope=${this.scope}
    &approval_prompt=auto`;
    window.location.href = url;
  }
}
