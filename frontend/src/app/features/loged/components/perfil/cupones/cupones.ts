import { Component } from '@angular/core';
import {RouterModule} from '@angular/router';
import {Cupon} from '@loged/components/cupon/cupon';

@Component({
  selector: 'app-cupones',
  imports: [RouterModule, Cupon],
  templateUrl: './cupones.html',
  styleUrl: './cupones.css',
})
export class Cupones {

}
