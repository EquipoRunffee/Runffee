import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Home } from './pages/home/home';



@NgModule({
  declarations: [
    Home
  ],
  exports: [
    Home
  ],
  imports: [
    CommonModule
  ]
})
export class NologedModule { }
