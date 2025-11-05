import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Navbarperfil } from '@loged/components/perfil/navbar/navbarperfil';
import { Header } from './components/perfil/header/header';



@NgModule({
  declarations: [
    Navbarperfil,
    Header
  ],
  exports: [
    Header
  ],
  imports: [
    CommonModule,
  ]
})
export class LogedModule { }
