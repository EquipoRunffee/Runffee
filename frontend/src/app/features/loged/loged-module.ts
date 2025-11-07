import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Navbarperfil } from '@loged/components/perfil/navbarperfil/navbarperfil';
import { Header } from './components/perfil/header/header';

@NgModule({
  declarations: [

  ],
  exports: [
    Header,
    Navbarperfil
  ],
  imports: [
    CommonModule,
    Header,
    Navbarperfil,
  ]
})
export class LogedModule { }
