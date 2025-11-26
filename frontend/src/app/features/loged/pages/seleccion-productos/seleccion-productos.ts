import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router, RouterLink} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {Navbar} from '@loged/components/navbar/navbar';
import {Footer} from '@shared/components/footer/footer';
import {CardProducto} from '@loged/components/card-producto/card-producto';
import {CafeteriaService} from '@core/services/cafeteria/cafeteriaService';
import {CafeteriaProductos} from '@core/models/cafeteria-productos';
import {Observable} from 'rxjs';
import {AsyncPipe} from '@angular/common';

@Component({
  selector: 'app-seleccion-productos',
  standalone: true,
  templateUrl: './seleccion-productos.html',
  styleUrl: './seleccion-productos.css',
  imports: [
    Navbar,
    Footer,
    RouterLink,
    CardProducto,
    AsyncPipe
  ]
})
export class SeleccionProductos implements OnInit {
  idCafeteria!: number;
  categoriaAbierta: number | null = null;
  datos: CafeteriaProductos | null = null;

  constructor(private router: Router,
              private http: HttpClient,
              private route: ActivatedRoute
              ,private cafeteriaService: CafeteriaService) {}

  ngOnInit() {
    this.idCafeteria = this.route.snapshot.params['id'];
    this.cafeteriaService.getProductosCafeteria(this.idCafeteria).subscribe({
      next: data => {
        this.datos = data;
        console.log(this.datos);
      },
      error: error => {
        console.log(error);
      }
    });
  }

  abrirCategoria(id: number): void {
    this.categoriaAbierta = this.categoriaAbierta === id ? null : id;
  }
}
