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
      console.log('Codigo recibido de Strava: ', code);

      this.http.post(url, {code}).subscribe(
        {
          next: (res)=>{
            console.log("Tokens recibidos del backend: ", res);
          },
          error: (err)=>{
            console.log(err);
          }
        }
      )

    }

  }



}
