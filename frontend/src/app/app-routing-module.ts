import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {Home} from '@nologed/pages/home/home';
import {PerfilComponent} from '@loged/pages/perfil/perfil.component';
import {ConexionStrava} from '@nologed/pages/conexion-strava/conexion-strava';
import {Login} from '@nologed/pages/login/login';
import {Callback} from '@nologed/pages/callback/callback';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: Home },
  {path: 'perfil', component: PerfilComponent},
  {path: 'strava/callback', component: Callback},
  {path: 'strava', component: ConexionStrava},
  {path: 'login', component: Login},
  {path: 'perfil', component: PerfilComponent},
  { path: '**', redirectTo: '/home' },
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
