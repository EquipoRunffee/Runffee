export class adminUsuario {
  correo: string;
  contrasena: string;
  rol: string;
  eliminado: boolean;

  constructor(correo: string, contrasena: string, rol: string, eliminado: boolean) {
    this.correo = correo;
    this.contrasena = contrasena;
    this.rol = rol;
    this.eliminado = eliminado;
  }
}
