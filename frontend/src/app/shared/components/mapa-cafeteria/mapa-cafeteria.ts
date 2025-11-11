import {Component, ViewChild} from '@angular/core';
import {GoogleMap, MapInfoWindow, MapMarker} from '@angular/google-maps';

@Component({
  selector: 'app-mapa-cafeteria',
  standalone: true,
  templateUrl: './mapa-cafeteria.html',
  styleUrl: './mapa-cafeteria.css',
  imports: [
    GoogleMap,
    MapMarker,
    MapInfoWindow
  ]
})
export class MapaCafeteria {

  center: google.maps.LatLngLiteral = { lat: 37.392271185986054, lng: -5.997439550816082 };

  zoom = 14;
  options: google.maps.MapOptions = {
    mapTypeId: 'roadmap',
    fullscreenControl: true,
    streetViewControl: false
  };

  // Un solo marcador (tu cafetería)
  markerPosition: google.maps.LatLngLiteral = { lat: 37.39228343926812, lng: -5.997434186398337 };
  markerTitle = 'Mi Cafetería';

  // Contenido del InfoWindow
  infoContent = `<strong>Mi Cafetería</strong><br>Calle Falsa 123<br>Abierto: 08:00 - 20:00`;

  @ViewChild(MapInfoWindow) infoWindow!: MapInfoWindow;

  openInfo(marker: MapMarker) {
    this.infoWindow.open(marker);
  }

  // Ejemplo: centrar mapa en la posición del marcador (útil si la posición se actualiza)
  recenterOnMarker() {
    this.center = { ...this.markerPosition };
  }
}
