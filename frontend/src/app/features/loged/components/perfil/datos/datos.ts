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
  datosCargados: boolean = false;

  constructor(private usuarioService: UsuarioService) {}

  ngOnInit(): void {
    this.usuarioService.getDatosPerfil().subscribe({
      next: (data) => {
        this.datosCargados = true;
        this.datosUsuario = data
      },
      error: (err) => console.error('Error al cargar datos del usuario:', err)
    });
  }
}
