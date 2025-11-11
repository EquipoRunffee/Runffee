import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {Home} from '@nologed/pages/home/home';
import {PerfilComponent} from '@loged/pages/perfil/perfil.component';
import {ConexionStrava} from '@nologed/pages/conexion-strava/conexion-strava';
import {Login} from '@nologed/pages/login/login';
import {Callback} from '@nologed/pages/callback/callback';

// @ts-ignore
const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: Home },
  { path: 'perfil',
    loadComponent: () => import('@loged/pages/perfil/perfil.component').then(m => m.PerfilComponent),
    loadChildren: () => import('@loged/pages/perfil/perfil.routes').then(m => m.PERFIL_ROUTES)
  },
  {path: 'strava/callback', component: Callback},
  {path: 'strava', component: ConexionStrava},
  {path: 'login', component: Login},
  { path: '**', redirectTo: '/home' },
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
