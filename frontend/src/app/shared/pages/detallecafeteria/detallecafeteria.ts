import {Component, OnInit} from '@angular/core';
import {CafeteriaService} from '@core/services/cafeteria/cafeteriaService';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Cafeteria} from '@core/models/cafeteria';

@Component({
  selector: 'app-detallecafeteria',
  standalone: true,
  templateUrl: './detallecafeteria.html',
  styleUrl: './detallecafeteria.css',
})
export class Detallecafeteria implements OnInit {
  detallecafeteria: Cafeteria|null = null;


  constructor(private cafeteriaService: CafeteriaService,http: HttpClient) {

    }

    ngOnInit() {
      this.cafeteriaService.getCafeteriaPorId(1).subscribe({
        next: data => {
          console.log(data);
          this.detallecafeteria = data;
        },
        error: error => {
          console.log(error);
        }
      })
    }

}
