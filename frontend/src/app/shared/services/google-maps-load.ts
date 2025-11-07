import { Injectable } from '@angular/core';
import {environment} from '@enviroment/environment';
@Injectable({
  providedIn: 'root',
})
export class GoogleMapsLoad {
  private scriptLoaded = false;

  load(): Promise<void> {
    return new Promise((resolve, reject) => {
      if (this.scriptLoaded) {
        resolve();
        return;
      }

      const script = document.createElement('script');
      script.src = `https://maps.googleapis.com/maps/api/js?key=${environment.googleMapsApiKey}`;
      script.async = true;
      script.defer = true;

      script.onload = () => {
        this.scriptLoaded = true;
        resolve();
      };
      script.onerror = (err) => reject(err);

      document.head.appendChild(script);
    });
  }
}
