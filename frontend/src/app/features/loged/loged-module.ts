import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Navbarperfil } from '@loged/components/perfil/navbarperfil/navbarperfil';
import { Header } from './components/perfil/header/header';
import { Cupones } from './components/perfil/cupones/cupones';
import { HomeApp } from './pages/home-app/home-app';
import {CafeteriaCard} from '@shared/components/cafeteriaCard/cafeteriaCard';
import { CardReto } from './components/card-reto/card-reto';
import { Navbar } from './components/navbar/navbar';
import { SeleccionProductos } from './pages/seleccion-productos/seleccion-productos';
import { Cupon } from '@loged/components/cupon/cupon';
import {Actividad} from '@loged/components/perfil/actividad/actividad';
import { CardProducto } from './components/card-producto/card-producto';

@NgModule({
  declarations: [
  ],
  exports: [
    Header,
    Navbarperfil,
    Cupon,
    Navbarperfil,
    Actividad,
    Navbar,
    SeleccionProductos,
    CardProducto,
  ],
  imports: [
    CommonModule,
    Header,
    Navbarperfil,
    Cupon,
    Actividad,
    CafeteriaCard,
    HomeApp,
    Navbar,
    SeleccionProductos,
    CardProducto,
  ]
})
export class LogedModule { }
