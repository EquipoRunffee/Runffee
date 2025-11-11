import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Navbarperfil } from '@loged/components/perfil/navbarperfil/navbarperfil';
import { Header } from './components/perfil/header/header';
import {Actividad} from '@loged/components/actividad/actividad';

@NgModule({
  declarations: [

  ],
  exports: [
    Header,
    Navbarperfil,
    Actividad,
  ],
  imports: [
    CommonModule,
    Header,
    Navbarperfil,
    Actividad,
  ]
})
export class LogedModule { }
