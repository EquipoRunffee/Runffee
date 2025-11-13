import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-callback',
  standalone: false,
  templateUrl: './callback.html',
  styleUrl: './callback.css',
})
export class Callback implements OnInit {
  constructor(private route: ActivatedRoute,
  private http: HttpClient) {}

  ngOnInit() {

    const code = this.route.snapshot.queryParamMap.get('code');

    const url = "https://runffee.onrender.com/strava/exchange";

    if (code) {
      console.log('Codigo recibido de StravaService: ', code);

      this.http.post(url, {code}).subscribe(
        {
          //Esto es la respuesta de nuestro backend
          next: (res)=>{
            alert("YA HAN CARGADO LOS DATOS");
            console.log("Tokens recibidos del backend: ", res);
          },
          error: (err)=>{
            console.log(err);
          }
        }
      )

      //Este console log se ejecuta antes de recibir la respuesta a la petición porque no está dentro del suscribe
      console.log("Hola");

    }

  }



}
