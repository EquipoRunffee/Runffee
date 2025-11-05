import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { Home } from './pages/home/home';
import { Footer } from '@shared/components/footer/footer';
import { NavbarComponent } from '@shared/components/navbar/navbar';

@NgModule({
  declarations: [
    Home,
  ],
  exports: [
    Home,
    Footer,
    NavbarComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    Footer,
    NavbarComponent
  ]
})
export class NologedModule { }
