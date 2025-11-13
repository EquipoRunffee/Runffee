import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {Home} from '@nologed/pages/home/home';
import {Login} from '@nologed/pages/login/login';
import {Register} from '@nologed/pages/register/register';
import {Callback} from '@nologed/pages/callback/callback';
import {Cafeterias} from '@nologed/pages/cafeterias/cafeterias';
import {CafeteriaCard} from '@shared/components/cafeteriaCard/cafeteriaCard';
import { Actividad } from "@loged/components/actividad/actividad";

// @ts-ignore
const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: Home },
  { path: 'perfil',
    loadComponent: () => import('@loged/pages/perfil/perfil').then(m => m.Perfil),
    loadChildren: () => import('@loged/pages/perfil/perfil.routes').then(m => m.PERFIL_ROUTES)
  },
  { path: 'cafeterias', component: Cafeterias },
  { path: 'cafeteria', component: CafeteriaCard },
  {path: 'callback', component: Callback},
  {path: 'login', component: Login},
  {path: 'register', component: Register},
  { path: 'actividad', component: Actividad },
  { path: '**', redirectTo: '/home' },
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
