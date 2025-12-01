import {Component, OnInit} from '@angular/core';
import {UsuarioService} from '@core/services/usuario/usuarioService';
import {usuarioDatosPerfil} from '@core/models/usuarioDatosPerfil';

@Component({
  selector: 'app-header',
  templateUrl: './header.html',
  styleUrl: './header.css',
})
export class Header implements OnInit {

  datosUsuario!: usuarioDatosPerfil;
  datosCargados: boolean = false;

  constructor(private usuarioService: UsuarioService) {}

  ngOnInit(): void {
    this.usuarioService.getDatosPerfil().subscribe({
      next: (data) => {
        this.datosCargados = true;
        this.datosUsuario = data},
      error: (err) => console.error('Error al cargar datos del usuario:', err)
    });
  }
}
