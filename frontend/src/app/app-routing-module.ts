import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {Home} from '@nologed/pages/home/home';
import {Perfil} from '@loged/pages/perfil/perfil';
import {ConexionStrava} from '@nologed/pages/conexion-strava/conexion-strava';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: Home },
  {path: 'perfil', component: Perfil},
  {path: 'strava', component: ConexionStrava},
  { path: '**', redirectTo: '/home' },
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
