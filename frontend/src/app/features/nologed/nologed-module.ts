import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { Home } from './pages/home/home';
import { Footer } from '@shared/components/footer/footer';
import { NavbarComponent } from '@shared/components/navbar/navbar';
import { Callback } from './pages/callback/callback';
import { CafeteriaCard } from '@shared/components/cafeteriaCard/cafeteriaCard';
import {MapaGoogle} from '@shared/components/mapa-google/mapa-google';

@NgModule({
  declarations: [
    Home,
    Callback,
  ],

  exports: [
    Home,
    Footer,
    NavbarComponent,
    MapaGoogle,
    CafeteriaCard,
  ],
  imports: [
    CommonModule,
    RouterModule,
    Footer,
    NavbarComponent,
    MapaGoogle,
    CafeteriaCard,
  ]
})
export class NologedModule { }
