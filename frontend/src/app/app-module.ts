import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { HttpClientModule } from '@angular/common/http';
import { Footer } from '@shared/components/footer/footer';
import {NologedModule} from '@nologed/nologed-module';
import { NavbarComponent } from '@shared/components/navbar/navbar';


@NgModule({
  declarations: [
    App,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NologedModule,
    Footer,
    NavbarComponent,
  ],
  providers: [
    provideBrowserGlobalErrorListeners()
  ],
  exports: [
    Footer,
    NavbarComponent,
  ],
  bootstrap: [App]
})
export class AppModule { }
