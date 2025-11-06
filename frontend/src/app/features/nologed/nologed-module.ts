import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { Home } from './pages/home/home';
import { Footer } from '@shared/components/footer/footer';
import { NavbarComponent } from '@shared/components/navbar/navbar';
import { ConexionStrava } from './pages/conexion-strava/conexion-strava';
import { Callback } from './pages/callback/callback';

@NgModule({
  declarations: [
    Home,
    ConexionStrava,
    Callback,
  ],
  exports: [
    Home,
    Footer,
    NavbarComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    Footer,
    NavbarComponent
  ]
})
export class NologedModule { }
