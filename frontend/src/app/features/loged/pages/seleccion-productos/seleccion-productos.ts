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
import {Carrito} from '@core/models/carrito';
import {CarritoService} from '@core/services/carrito/carritoService';

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
  ]
})
export class SeleccionProductos implements OnInit {
  idCafeteria!: number;
  categoriaAbierta: number | null = null;
  datos: CafeteriaProductos | null = null;

  constructor(private router: Router,
              private http: HttpClient,
              private route: ActivatedRoute
              ,private cafeteriaService: CafeteriaService,
              private carritoService: CarritoService) {}

  ngOnInit() {
    this.idCafeteria = this.route.snapshot.params['id'];
    this.carritoService.setIdCafeteria(this.idCafeteria);

    this.cafeteriaService.getProductosCafeteria(this.idCafeteria).subscribe({
      next: data => {
        this.datos = data;
      },
      error: error => {
        console.log(error);
      }
    });
  }
}
