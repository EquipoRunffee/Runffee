import {Component, OnInit} from '@angular/core';
import {Router, RouterModule} from '@angular/router';
import {entrenamientoDetalles} from '@core/models/entrenamientoDetalles';
import {UsuarioService} from '@core/services/usuario/usuarioService';
import {EntrenamientoService} from '@core/services/entrenamiento/entrenamientoService';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-entrenamiento',
  imports: [RouterModule],
  templateUrl: './entrenamiento.html',
  styleUrl: './entrenamiento.css',
})
export class Entrenamiento {

  // entrenamiento: entrenamientoDetalles = {
  //   nombre:'',
  //   fecha: null,
  //   distancia: 0
  // }
  //
  // constructor(private router: Router, private entrenamientoService: EntrenamientoService) {}
  //
  //
  // ngOnInit() {
  //   const usuarioId = 15;
  //   this.entrenamientoService.getEntrenamientoDetalles(usuarioId).subscribe(
  //
  //   )
  // }


  constructor(private router: Router) {}

  mostrarActividad() {
    this.router.navigate(['/perfil/actividad']);
  }
}
