import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import {HTTP_INTERCEPTORS, HttpClientModule, provideHttpClient, withInterceptors} from '@angular/common/http';
import { Footer } from '@shared/components/footer/footer';
import {NologedModule} from '@nologed/nologed-module';
import {LogedModule} from '@loged/loged-module';
import { NavbarComponent } from '@shared/components/navbar/navbar';
import {FormsModule} from '@angular/forms';
import { MapaCafeteria } from './shared/components/mapa-cafeteria/mapa-cafeteria';
import {GoogleMap, MapInfoWindow, MapMarker} from '@angular/google-maps';
import { CafeteriaCard } from './shared/components/cafeteriaCard/cafeteriaCard';
import {authInterceptor} from '@core/interceptor/auth-interceptor';
import {CardReto} from '@loged/components/card-reto/card-reto';
import { ValoracionCard } from './shared/components/valoracion-card/valoracion-card';
import { Detallecafeteria } from './shared/pages/detallecafeteria/detallecafeteria';
import { EntrenamientoCard } from './shared/components/entrenamiento-card/entrenamiento-card';
import { ValoracionPaginaCafeteriasCard } from './shared/components/valoracion-pagina-cafeterias-card/valoracion-pagina-cafeterias-card';
import { ProductosMasVendidosCard } from './shared/components/productos-mas-vendidos-card/productos-mas-vendidos-card';


@NgModule({
  declarations: [App, ValoracionPaginaCafeteriasCard, ProductosMasVendidosCard,],
  providers: [
    provideHttpClient(
      withInterceptors([authInterceptor])
    ),
    provideBrowserGlobalErrorListeners()
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NologedModule,
    LogedModule,
    Footer,
    NavbarComponent,
    FormsModule,
    GoogleMap,
    MapInfoWindow,
    MapMarker,
    MapaCafeteria,
    CafeteriaCard,
    CardReto,
    ValoracionCard,
    EntrenamientoCard
  ],
  exports: [
    Footer,
    NavbarComponent,
    CafeteriaCard,
    EntrenamientoCard,
    ValoracionPaginaCafeteriasCard,
  ],
  bootstrap: [App]
})
export class AppModule { }
