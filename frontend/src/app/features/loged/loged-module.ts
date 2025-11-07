import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Navbarperfil } from '@loged/components/perfil/navbarperfil/navbarperfil';
import { Header } from './components/perfil/header/header';

@NgModule({
  declarations: [
    Navbarperfil
  ],
  exports: [
    Header,
    Navbarperfil
  ],
  imports: [
    CommonModule,
    Header,
  ]
})
export class LogedModule { }
