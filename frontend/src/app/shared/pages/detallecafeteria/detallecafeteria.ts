import {Component, OnInit} from '@angular/core';
import {CafeteriaService} from '@core/services/cafeteria/cafeteriaService';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Cafeteria} from '@core/models/cafeteria';
import {DatePipe, NgForOf} from '@angular/common';
import {ValoracionCard} from '@shared/components/valoracion-card/valoracion-card';

@Component({
  selector: 'app-detallecafeteria',
  standalone: true,
  templateUrl: './detallecafeteria.html',
  styleUrl: './detallecafeteria.css',
  imports: [
    DatePipe,
    NgForOf,
    ValoracionCard
  ]
})
export class Detallecafeteria implements OnInit {
  datos:any = null;
  constructor(private cafeteriaService: CafeteriaService,http: HttpClient) {}

    ngOnInit() {
      this.cafeteriaService.traerCafeteriaPorId(1).subscribe({
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
