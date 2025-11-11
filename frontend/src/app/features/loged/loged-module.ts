import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarperfilComponent } from '@loged/components/perfil/navbarperfil/navbarperfil.component';
import { Header } from './components/perfil/header/header';

@NgModule({
  declarations: [

  ],
  exports: [
    Header,
    NavbarperfilComponent
  ],
  imports: [
    CommonModule,
    Header,
    NavbarperfilComponent,
  ]
})
export class LogedModule { }
