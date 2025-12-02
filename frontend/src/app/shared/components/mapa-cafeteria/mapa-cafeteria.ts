import {Component, Input, ViewChild} from '@angular/core';
import {GoogleMap, MapInfoWindow, MapMarker} from '@angular/google-maps';

@Component({
  selector: 'app-mapa-cafeteria',
  standalone: true,
  templateUrl: './mapa-cafeteria.html',
  styleUrl: './mapa-cafeteria.css',
  imports: [
    GoogleMap,
    MapMarker,
  ]
})
export class MapaCafeteria {

  @Input() lat!: number;
  @Input() lng!: number;

  zoom = 14;
  options: google.maps.MapOptions = {
    mapTypeId: 'roadmap',
    fullscreenControl: true,
    streetViewControl: false
  };

  center!: google.maps.LatLngLiteral;
  markerPosition!: google.maps.LatLngLiteral;

  ngOnInit() {
    this.center = { lat: this.lat, lng: this.lng };
    this.markerPosition = { lat: this.lat, lng: this.lng };
  }
}
