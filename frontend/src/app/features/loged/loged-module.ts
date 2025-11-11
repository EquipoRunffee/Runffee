import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Navbarperfil } from '@loged/components/perfil/navbarperfil/navbarperfil';
import { Header } from './components/perfil/header/header';
import { Cupones } from './components/perfil/cupones/cupones';
import { Cupon } from './components/cupon/cupon';

@NgModule({
  declarations: [

  
    Cupones,
        Cupon
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
