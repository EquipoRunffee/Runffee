import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Navbarperfil } from '@loged/components/perfil/navbarperfil/navbarperfil';
import { Header } from './components/perfil/header/header';
import { Cupones } from './components/perfil/cupones/cupones';
import { Cupon } from './components/cupon/cupon';
import {Actividad} from '@loged/components/actividad/actividad';
import { HomeApp } from './pages/home-app/home-app';
import {CafeteriaCard} from '@shared/components/cafeteriaCard/cafeteriaCard';
import { CardReto } from './components/card-reto/card-reto';
import { Navbar } from './components/navbar/navbar';

@NgModule({
  declarations: [
  ],
  exports: [
    Header,
    Navbarperfil,
    Cupon,
    Navbarperfil,
    Actividad,
    Navbar,
  ],
  imports: [
    CommonModule,
    Header,
    Navbarperfil,
    Cupon,
    Actividad,
    CafeteriaCard,
    HomeApp,
    Navbar,
  ]
})
export class LogedModule { }
