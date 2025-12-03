import {Component, OnInit} from '@angular/core';
import {CafeteriaService} from '@core/services/cafeteria/cafeteriaService';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-controlcafeteria',
  standalone: false,
  templateUrl: './controlcafeteria.html',
  styleUrl: './controlcafeteria.css',
})
export class Controlcafeteria implements OnInit {

    datos:any = null;
    constructor(private cafeteriaService: CafeteriaService,http: HttpClient) {}

    ngOnInit() {
      this.cafeteriaService.getCafeteriaPorId(1).subscribe({
        next: data => {
          console.log(data);
          this.datos = data;
        },
        error: error => {
          console.log(error);
        }
      })
    }

}
