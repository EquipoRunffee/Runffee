import { Component, OnInit } from '@angular/core';
import {RouterModule} from '@angular/router';
import { usuarioDatosPerfil } from "@core/models/usuarioDatosPerfil";
import { AuthService } from "@core/services/auth/auth-service";
import { UsuarioService } from "@core/services/usuario/usuarioService";

@Component({
  selector: 'app-datos',
  imports: [RouterModule],
  templateUrl: './datos.html',
  styleUrls: ['./datos.css'],
})
export class Datos implements OnInit {

  datosUsuario!: usuarioDatosPerfil;

  constructor(
    private usuarioService: UsuarioService,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    const idUsuario = this.authService.getUserId();

    if (!idUsuario) {
      console.error("No se encontró ID de usuario en el token");
      return;
    }

    this.usuarioService.getDatosPerfil(idUsuario).subscribe({
      next: (data) => this.datosUsuario = data,
      error: (err) => console.error('Error al cargar datos del usuario:', err)
    });
  }
}
