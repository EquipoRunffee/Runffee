import {Component, OnInit} from '@angular/core';
import {UsuarioService} from '@core/services/usuario/usuarioService';
import {usuarioEncabezadoPerfil} from '@core/models/usuarioEncabezadoPerfil';

@Component({
  selector: 'app-header',
  templateUrl: './header.html',
  styleUrl: './header.css',
})
export class Header implements OnInit {

  usuario: usuarioEncabezadoPerfil = {
    nombre: '',
    correo: '',
    totalEntrenamientos: 0
  }

  constructor(private usuarioService:UsuarioService) {}

  ngOnInit():void {
    this.usuarioService.getEncabezadoPerfil().subscribe({
      next: (data) => this.usuario = data,
      error: (err) => console.error('Error al cargar datos del usuario:', err)
    });
  }
}
