import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router, RouterLink} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {Navbar} from '@loged/components/navbar/navbar';
import {Footer} from '@shared/components/footer/footer';
import {NgClass, NgForOf} from '@angular/common';
import {CardProducto} from '@loged/components/card-producto/card-producto';

@Component({
  selector: 'app-seleccion-productos',
  standalone: true,
  templateUrl: './seleccion-productos.html',
  styleUrl: './seleccion-productos.css',
  imports: [
    Navbar,
    Footer,
    RouterLink,
    NgClass,
    NgForOf,
    CardProducto
  ]
})
export class SeleccionProductos implements OnInit {
  idCafeteria!: number | null;
  categoriaAbierta: number | null = null;

  constructor(private router: Router, private http: HttpClient, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.idCafeteria = this.route.snapshot.params['id'];
    console.log("IdCafeteria", this.idCafeteria);
  }

  abrirCategoria(id: number): void {
    this.categoriaAbierta = this.categoriaAbierta === id ? null : id;
  }
}
