import {Component, OnInit} from '@angular/core';
import {UsuarioService} from '@core/services/usuario/usuarioService';
import {usuarioEncabezadoPerfil} from '@core/models/usuarioEncabezadoPerfil';
import {AuthService} from '@core/services/auth/auth-service';

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

  constructor(
    private usuarioService:UsuarioService,
    private authService: AuthService,
  ) {}

  ngOnInit():void {
    const idUsuario = this.authService.getUserId();

    this.usuarioService.getEncabezadoPerfil(idUsuario).subscribe({
      next: (data) => this.usuario = data,
      error: (err) => console.error('Error al cargar datos del usuario:', err)
    });
  }
}
