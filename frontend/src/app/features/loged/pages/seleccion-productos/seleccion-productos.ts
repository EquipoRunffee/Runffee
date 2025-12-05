import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router, RouterLink} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {Navbar} from '@loged/components/navbar/navbar';
import {Footer} from '@shared/components/footer/footer';
import {CardProducto} from '@loged/components/card-producto/card-producto';
import {CafeteriaService} from '@core/services/cafeteria/cafeteriaService';
import {CafeteriaProductos} from '@core/models/cafeteria-productos';
import {CarritoService} from '@core/services/carrito/carritoService';
import { CommonModule } from '@angular/common';
import {FormsModule} from '@angular/forms';
import {ProductoSeleccion} from '@core/models/producto-seleccion';

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
    CommonModule,
    FormsModule,
  ]
})
export class SeleccionProductos implements OnInit {
  idCafeteria!: number;
  datos: CafeteriaProductos | null = null;
  productos: ProductoSeleccion[] = [];
  productosFiltrados: ProductoSeleccion[] = [];
  tipos: string[] = [];
  tipoSeleccionado: string = 'Todos';
  encontrarProducto: string = '';
  isLoaded: boolean = false;

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
        this.productos = data.productos;
        this.productosFiltrados = data.productos;
        this.obtenerTipos();
        this.isLoaded = true;
        console.log(this.productos);
      },
      error: error => {
        console.log(error);
      }
    });
  }

  obtenerTipos() {
    const tiposUnicos = new Set<string>();

    this.productos.forEach(producto => {
      tiposUnicos.add(producto.tipoProducto);
    });

    this.tipos = Array.from(tiposUnicos);
  }

  get datosFiltrados() {
    let filtrados = this.productos;

    if (this.tipoSeleccionado !== 'Todos') {
      filtrados = filtrados.filter(p => p.tipoProducto === this.tipoSeleccionado);
    }

    if (this.encontrarProducto) {
      const busqueda = this.encontrarProducto.toLowerCase();
      filtrados = filtrados.filter(p => p.nombre.toLowerCase().startsWith(busqueda));
    }

    return filtrados;
  }
}
