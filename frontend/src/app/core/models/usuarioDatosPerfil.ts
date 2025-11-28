export class usuarioDatosPerfil {
  nombre: string;
  apellidos: string;
  correo: string;
  ciudad: string;
  pais: string;
  sexo: string;
  totalEntrenamientos: number;

  constructor(nombre: string, apellidos: string, correo: string, ciudad: string, pais: string, sexo: string, totalEntrenamientos: number) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.correo = correo;
    this.ciudad = ciudad;
    this.pais = pais;
    this.sexo = sexo;
    this.totalEntrenamientos = totalEntrenamientos;
  }
}
