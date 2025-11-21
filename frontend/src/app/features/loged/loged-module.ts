import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Navbarperfil } from '@loged/components/perfil/navbarperfil/navbarperfil';
import { Header } from './components/perfil/header/header';
import { Cupones } from './components/perfil/cupones/cupones';
import { Cupon } from '@loged/components/perfil/cupon/cupon';
import {Actividad} from '@loged/components/perfil/actividad/actividad';

@NgModule({
  declarations: [

  ],
  exports: [
    Header,
    Navbarperfil,
    Cupon,
    Navbarperfil,
    Actividad,
  ],
  imports: [
    CommonModule,
    Header,
    Navbarperfil,
    Cupon,
    Actividad,
  ]
})
export class LogedModule { }
