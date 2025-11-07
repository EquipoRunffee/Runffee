import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


import { PerfilComponent } from './perfil.component';
import { DatosComponent } from '@loged/components/perfil/datos/datos.component';
import { ActividadesComponent } from '@loged/components/perfil/actividades/actividades.component';
import { ContrasenaComponent } from '@loged/components/perfil/contrasena/contrasena.component';
import { NotificacionesComponent } from '@loged/components/perfil/notificaciones/notificaciones.component';
import { ValoracionesComponent } from '@loged/components/perfil/valoraciones/valoraciones.component';
import { AyudaComponent } from '@loged/components/perfil/ayuda/ayuda.component';

const routes: Routes = [
  {
    path: '',
    component: PerfilComponent,
    children: [
      { path: 'datos', component: DatosComponent },
      { path: 'actividades', component: ActividadesComponent },
      { path: 'contrasena', component: ContrasenaComponent },
      { path: 'notificaciones', component: NotificacionesComponent },
      { path: 'valoraciones', component: ValoracionesComponent },
      { path: 'ayuda', component: AyudaComponent },
      { path: '', redirectTo: 'datos', pathMatch: 'full' }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PerfilRoutingModule {}
