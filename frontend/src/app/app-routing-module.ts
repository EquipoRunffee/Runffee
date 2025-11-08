import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {Home} from '@nologed/pages/home/home';
import {Perfil} from '@loged/pages/perfil/perfil';
import {ConexionStrava} from '@nologed/pages/conexion-strava/conexion-strava';
import {Login} from '@nologed/pages/login/login';
import {Callback} from '@nologed/pages/callback/callback';
import {Cafeterias} from '@nologed/pages/cafeterias/cafeterias';
import {Cafeteria} from '@shared/components/cafeteria/cafeteria';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: Home },
  { path: 'cafeterias', component: Cafeterias },
  { path: 'cafeteria', component: Cafeteria },
  {path: 'perfil', component: Perfil},
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
