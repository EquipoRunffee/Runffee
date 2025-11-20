import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {Home} from '@nologed/pages/home/home';
import {Login} from '@nologed/pages/login/login';
import {Register} from '@nologed/pages/register/register';
import {Callback} from '@nologed/pages/callback/callback';
import {Cafeterias} from '@nologed/pages/cafeterias/cafeterias';
import { Actividad } from "@loged/components/actividad/actividad";
import { HomeApp } from "@loged/pages/home-app/home-app";
//import {authGuardGuard} from '@core/guard/auth-guard-guard';
import {CafeteriaCard} from '@shared/components/cafeteriaCard/cafeteriaCard';

const routes: Routes = [

  //PAGINAS NOLOGED
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: Home },
  { path: 'cafeterias', component: Cafeterias },
  {path: 'callback', component: Callback},
  {path: 'login', component: Login},
  {path: 'register', component: Register},
  { path: 'actividad', component: Actividad },
  { path: 'cafeteria', component: CafeteriaCard },

  //PAGINAS LOGED
  { path: 'app', component: HomeApp },
  { path: 'app/home', component: HomeApp },
  {
    path: 'app',
    loadChildren: () =>
      import('@loged/loged-module').then(m => m.LogedModule),
    //canLoad: [authGuardGuard]
  },
  {
    path: 'app/perfil',
    loadComponent: () => import('@loged/pages/perfil/perfil').then(m => m.Perfil),
    loadChildren: () =>
      import('@loged/pages/perfil/perfil.routes').then(m => m.PERFIL_ROUTES)
  },

  { path: '**', redirectTo: '/home' },

]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
