import {AfterViewInit, Component, Input} from '@angular/core';
import * as L from 'leaflet';
import polyline from '@mapbox/polyline';

@Component({
  selector: 'app-mapa-entrenamiento',
  standalone: true,
  templateUrl: './mapa-entrenamiento.html',
  styleUrl: './mapa-entrenamiento.css',
})
export class MapaEntrenamiento implements AfterViewInit{
  @Input() encodedPolyline!: string;

  private map!: L.Map;

  ngAfterViewInit(): void {
    this.initMap();
  }

  private initMap(): void {

    // Crear mapa básico
    this.map = L.map('map', {
      center: [40, -3], // Centro provisional
      zoom: 13
    });

    // Capa de mapa (OpenStreetMap)
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 18
    }).addTo(this.map);

    if (this.encodedPolyline) {
      this.mostrarPolyline();
    }
  }

  private mostrarPolyline() {
    // 1. Decodificar polyline en lista de coordenadas
    const coords: number[][] = polyline.decode(this.encodedPolyline);

// Mapear asegurando que cada elemento tenga al menos dos números
    const latlngs: [number, number][] = coords
      .filter(c => c.length >= 2) // eliminar cualquier array incompleto
      .map(c => [c[0], c[1]] as [number, number]);

    // 3. Dibujar la polyline en el mapa
    const poly = L.polyline(latlngs, { color: 'red' }).addTo(this.map);

    // 4. Centrar el mapa en la ruta
    this.map.fitBounds(poly.getBounds());
  }
}
