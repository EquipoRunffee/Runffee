export class ProductoCarrito {
  idCafeteria: number;
  idReto: number | null;

  constructor(idCafeteria: number, idReto: number | null) {
    this.idCafeteria = idCafeteria;
    this.idReto = idReto;
  }
}
