import { Component } from '@angular/core';
import {RouterModule} from '@angular/router';
import {NgOptimizedImage} from '@angular/common';

@Component({
  selector: 'app-navbarperfil',
  standalone: true,
  imports: [RouterModule, NgOptimizedImage],
  templateUrl: './navbarperfil.html',
  styleUrls: ['./navbarperfil.css'],
})
export class Navbarperfil {}
