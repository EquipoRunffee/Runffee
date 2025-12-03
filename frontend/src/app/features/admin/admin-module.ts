import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Adminpage } from './adminpage/adminpage';
import { Controlcafeteria } from './controlcafeteria/controlcafeteria';
import { Controlusuario } from './controlusuario/controlusuario';
import { Controlreto } from './controlreto/controlreto';
import { Controlentrenamiento } from './controlentrenamiento/controlentrenamiento';
import { Controlproducto } from './controlproducto/controlproducto';
import {RouterLink} from '@angular/router';



@NgModule({
  declarations: [
    Adminpage,
    Controlcafeteria,
    Controlusuario,
    Controlreto,
    Controlentrenamiento,
    Controlproducto
  ],
  imports: [
    CommonModule,
    RouterLink
  ]
})
export class AdminModule { }
