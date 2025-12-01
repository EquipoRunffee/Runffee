export class EntrenamientoDetalles {
  constructor(
    public id: number,
    public nombre: string = '',
    public fecha_fin: string = '',
    public strava_km: number = 1,
    public objetivo_km: number = 1,
  ) {}
}
