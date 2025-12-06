import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Adminpage } from './adminpage/adminpage';
import { Controlcafeteria } from './controlcafeteria/controlcafeteria';
import { Controlusuario } from './controlusuario/controlusuario';
import { Controlreto } from './controlreto/controlreto';
import { Controlentrenamiento } from './controlentrenamiento/controlentrenamiento';
import { Controlproducto } from './controlproducto/controlproducto';
import {RouterLink} from '@angular/router';
import {FormsModule} from '@angular/forms';



@NgModule({
  declarations: [

  ],
  imports: [
    Adminpage,
    Controlcafeteria,
    Controlusuario,
    Controlreto,
    Controlentrenamiento,
    Controlproducto,
    CommonModule,
    RouterLink,
    FormsModule
  ],
  exports: [
    Adminpage,
    Controlcafeteria,
    Controlusuario,
    Controlreto,
    Controlentrenamiento,
    Controlproducto,
    CommonModule,
    RouterLink,
    FormsModule
  ]
})
export class AdminModule { }
