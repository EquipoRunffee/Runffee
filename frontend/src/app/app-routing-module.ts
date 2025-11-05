import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {Home} from '@nologed/pages/home/home';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: Home },
  { path: '**', redirectTo: '/home' }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
