import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-callback',
  standalone: false,
  templateUrl: './callback.html',
  styleUrl: './callback.css',
})
export class Callback implements OnInit {
  constructor(private route: ActivatedRoute,
  private http: HttpClient,
  private router: Router
  ) {}

  ngOnInit() {

    const code = this.route.snapshot.queryParamMap.get('code');

    const url = "https://runffee.onrender.com/strava/exchange";

    if (code) {
      console.log('Codigo recibido de Strava: ', code);

      this.http.post<any>(url, {code}).subscribe( //el <any> es necesario pa
        {
          //Esto es la respuesta de nuestro backend
          next: (res)=>{
            console.log("Tokens recibidos del backend: ", res);
          if (res.status === 'login'){
            this.router.navigate(['/login']);
          } else if (res.status === 'register'){
            this.router.navigate(['/register']);
          }


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
