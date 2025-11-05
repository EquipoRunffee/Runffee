import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {Home} from '@nologed/pages/home/home';
import {Perfil} from '@loged/pages/perfil/perfil';
import {Login} from '@nologed/pages/login/login';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: Home },
  {path: 'perfil', component: Perfil},
  {path: 'login', component: Login},
  { path: '**', redirectTo: '/home' },
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
