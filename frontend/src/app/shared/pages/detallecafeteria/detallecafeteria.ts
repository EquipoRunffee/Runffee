import {Component, OnInit} from '@angular/core';
import {CafeteriaService} from '@core/services/cafeteria/cafeteriaService';
import {HttpClient} from '@angular/common/http';
import {NgForOf} from '@angular/common';
import {Footer} from '@shared/components/footer/footer';
import {Navbar} from '@loged/components/navbar/navbar';
import {MapaCafeteria} from '@shared/components/mapa-cafeteria/mapa-cafeteria';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-detallecafeteria',
  standalone: true,
  templateUrl: './detallecafeteria.html',
  styleUrl: './detallecafeteria.css',
  imports: [
    NgForOf,
    Footer,
    Navbar,
    MapaCafeteria
  ]
})
export class Detallecafeteria implements OnInit {
  datos:any = null;
  idCafeteria:any;
  constructor(private cafeteriaService: CafeteriaService,http: HttpClient, private route: ActivatedRoute, private router: Router) {}

    ngOnInit() {
      this.idCafeteria = this.route.snapshot.params['id'];

      this.cafeteriaService.traerCafeteriaPorId(this.idCafeteria).subscribe({
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
