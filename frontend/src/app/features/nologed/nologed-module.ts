import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { Home } from './pages/home/home';
import { Footer } from '@shared/components/footer/footer';
import { NavbarComponent } from '@shared/components/navbar/navbar';
import { ConexionStrava } from './pages/conexion-strava/conexion-strava';
import { Callback } from './pages/callback/callback';
import { Cafeterias } from './pages/cafeterias/cafeterias';
import {MapaGoogle} from '@shared/components/mapa-google/mapa-google';
import {GoogleMap, MapInfoWindow, MapMarker} from '@angular/google-maps';

@NgModule({
  declarations: [
    Home,
    ConexionStrava,
    Callback,
    Cafeterias,


  ],
  exports: [
    Home,
    Footer,
    NavbarComponent,
    MapaGoogle,
  ],
  imports: [
    CommonModule,
    RouterModule,
    Footer,
    NavbarComponent,
    MapaGoogle
  ]
})
export class NologedModule { }
