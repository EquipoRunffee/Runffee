import {Component, OnInit, ViewChild} from '@angular/core';
import {GoogleMap, MapInfoWindow, MapMarker} from '@angular/google-maps';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-mapa-google',
  templateUrl: './mapa-google.html',
  styleUrl: './mapa-google.css',
  imports: [
    CommonModule,
    MapMarker,
    MapInfoWindow,
    GoogleMap
  ],
  standalone: true
})
export class MapaGoogle {

  // Coordenadas de ejemplo: reemplaza por las tuyas
  center: google.maps.LatLngLiteral = { lat: 37.392271185986054, lng: -5.997439550816082 };

  zoom = 14; // zoom inicial
  options: google.maps.MapOptions = {
    mapTypeId: 'roadmap',
    fullscreenControl: true,
    streetViewControl: false
  };

  markers = [
    {
      position: { lat: 37.39228343926812, lng: -5.997434186398337 },
      title: 'Cafetería Central',
      info: 'Calle Mayor 1Horario: 8:00 - 20:00'
    },
    {
      position: { lat: 37.39279163093468, lng: -5.993650803238308  },
      title: 'Cafetería Norte',
      info: 'Avenida Norte 45Horario: 7:30 - 19:30'
    },
    {
      position: { lat: 37.39587433590697, lng: -5.995972354704065 },
      title: 'Cafetería Sur',
      info: 'Plaza del Sol 12Horario: 8:30 - 22:00'
    }
  ];

  @ViewChild(MapInfoWindow) infoWindow!: MapInfoWindow;
  infoContent = '';

  openInfo(marker: MapMarker, info: string) {
    this.infoContent = info;
    this.infoWindow.open(marker);
  }
}
