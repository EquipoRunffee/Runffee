import {Component, OnInit} from '@angular/core';
import {Apiprueba} from '@core/services/apiprueba';
import { Router } from '@angular/router';


@Component({
  selector: 'app-home',
  standalone: false,
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home implements OnInit {
  constructor(private api: Apiprueba) {
  }

  ngOnInit() {
    this.api.getPrueba().subscribe(
      data => {
        console.log(data);
      },
      error => {
        console.log(error);
      }
    )
  }
}
