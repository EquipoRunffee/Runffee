import { Routes } from '@angular/router';

export const PERFIL_ROUTES: Routes = [
  {
    path: '',
    children: [
      {
        path: 'datos',
        loadComponent: () =>
          import('@loged/components/perfil/datos/datos')
            .then(m => m.Datos)
      },
      {
        path: 'actividades',
        loadComponent: () =>
          import('@loged/components/perfil/actividades/actividades')
            .then(m => m.Actividades)
      },
      {
        path: 'contrasena',
        loadComponent: () =>
          import('@loged/components/perfil/contrasena/contrasena')
            .then(m => m.Contrasena)
      },
      {
        path: 'notificaciones',
        loadComponent: () =>
          import('@loged/components/perfil/notificaciones/notificaciones')
            .then(m => m.Notificaciones)
      },
      {
        path: 'valoraciones',
        loadComponent: () =>
          import('@loged/components/perfil/valoraciones/valoraciones')
            .then(m => m.Valoraciones)
      },
      {
        path: 'ayuda',
        loadComponent: () =>
          import('@loged/components/perfil/ayuda/ayuda')
            .then(m => m.Ayuda)
      },

      { path: '', redirectTo: 'datos', pathMatch: 'full' }
    ]
  }
];
