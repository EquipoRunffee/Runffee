import {Component, OnInit} from '@angular/core';
import {UsuarioService} from '@core/services/usuario/usuarioService';
import {UsuarioEncabezadoPerfil} from '@core/models/UsuarioEncabezadoPerfil';

@Component({
  selector: 'app-header',
  templateUrl: './header.html',
  styleUrl: './header.css',
})
export class Header implements OnInit {

  usuario: UsuarioEncabezadoPerfil = {
    nombre: '',
    correo: '',
    totalEntrenamientos: 0
  }

  constructor(private usuarioService:UsuarioService) {}

  ngOnInit():void {
    const usuarioId = 37;
    this.usuarioService.getEncabezadoPerfil(usuarioId).subscribe(
      data=> {
        this.usuario = data;
        console.log("Usuario cargado: ", this.usuario);
      },
      err => {
        console.log("Error: ", err);
      }
    );
  }
}
