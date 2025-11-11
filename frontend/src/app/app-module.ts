import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { HttpClientModule } from '@angular/common/http';
import { Footer } from '@shared/components/footer/footer';
import {NologedModule} from '@nologed/nologed-module';
import {LogedModule} from '@loged/loged-module';
import { NavbarComponent } from '@shared/components/navbar/navbar';
import {FormsModule} from '@angular/forms';
import { Cafeteria } from '@shared/components/cafeteria/cafeteria/cafeteria';


@NgModule({
  declarations: [
    App,
    Cafeteria,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NologedModule,
    LogedModule,
    Footer,
    NavbarComponent,
    FormsModule
  ],
  providers: [
    provideBrowserGlobalErrorListeners()
  ],
  exports: [
    Footer,
    NavbarComponent
  ],
  bootstrap: [App]
})
export class AppModule { }
