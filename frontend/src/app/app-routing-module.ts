import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {Home} from '@nologed/pages/home/home';
import {Login} from '@nologed/pages/login/login';
import {Register} from '@nologed/pages/register/register';
import {Callback} from '@nologed/pages/callback/callback';
import {Cafeterias} from '@nologed/pages/cafeterias/cafeterias';
import { HomeApp } from "@loged/pages/home-app/home-app";
import { adminGuard } from '@core/guards/admin/admin-guard';
//import {authGuardGuard} from '@core/guards/auth-guards-guards';
import {CafeteriaCard} from '@shared/components/cafeteriaCard/cafeteriaCard';
import { Actividad } from "@loged/components/perfil/actividad/actividad";
import {Detallecafeteria} from '@shared/pages/detallecafeteria/detallecafeteria';
import {SeleccionProductos} from '@loged/pages/seleccion-productos/seleccion-productos';
import {Pago} from '@loged/pages/pago/pago';
import {Adminpage} from '@admin/adminpage/adminpage';
import {Controlcafeteria} from '@admin/controlcafeteria/controlcafeteria';
import {Controlusuario} from '@admin/controlusuario/controlusuario';
import {Controlreto} from '@admin/controlreto/controlreto';
import {Controlentrenamiento} from '@admin/controlentrenamiento/controlentrenamiento';
import {Controlproducto} from '@admin/controlproducto/controlproducto';

const routes: Routes = [

  //PAGINAS NOLOGED
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: Home },
  { path: 'cafeterias', component: Cafeterias },
  {path: 'callback', component: Callback},
  {path: 'login', component: Login},
  {path: 'register', component: Register},
  { path: 'actividad', component: Actividad },
  { path: 'cafeteria', component: CafeteriaCard },

  //PAGINAS ADMIN
  {path: 'admin/adminpage', component: Adminpage, canActivate: [adminGuard]},
  {path: 'admin/controlcafeteria', component: Controlcafeteria, canActivate: [adminGuard]},
  {path: 'admin/controlusuario', component: Controlusuario, canActivate: [adminGuard]},
  {path: 'admin/controlreto', component: Controlreto, canActivate: [adminGuard]},
  {path: 'admin/controlentrenamiento', component: Controlentrenamiento, canActivate: [adminGuard]},
  {path: 'admin/controlproducto', component: Controlproducto, canActivate: [adminGuard]},


  //PAGINAS LOGED
  { path: 'app', component: HomeApp },
  { path: 'app/home', component: HomeApp },
  { path: 'app/seleccion-productos/:id', component: SeleccionProductos },
  { path: 'app/pago', component: Pago },
  {path: 'app/detallecafeteria/:id', component: Detallecafeteria},

  {
    path: 'app',
    loadChildren: () =>
      import('@loged/loged-module').then(m => m.LogedModule),
    //canActivate: [authGuardGuard]
    //canLoad: [authGuardGuard]
  },
  {
    path: 'app/perfil',
    loadComponent: () => import('@loged/pages/perfil/perfil').then(m => m.Perfil),
    loadChildren: () =>
      import('@loged/pages/perfil/perfil.routes').then(m => m.PERFIL_ROUTES)
  },
  { path: '**', redirectTo: '/home' },

  { path: '**', redirectTo: '/home' },

]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
