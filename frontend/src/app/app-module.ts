import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { HttpClientModule } from '@angular/common/http';
import { Footer } from '@shared/components/footer/footer';
import {NologedModule} from '@nologed/nologed-module';

@NgModule({
  declarations: [
    App,
    Footer
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NologedModule,
  ],
  providers: [
    provideBrowserGlobalErrorListeners()
  ],
  bootstrap: [App]
})
export class AppModule { }
