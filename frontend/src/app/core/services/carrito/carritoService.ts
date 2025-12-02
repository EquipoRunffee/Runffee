import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Carrito } from '@core/models/carrito';
import { ProductoCarrito } from '@core/models/producto-carrito';

@Injectable({
  providedIn: 'root',
})
export class CarritoService {
  private carrito: Carrito;
  private carritoSubject: BehaviorSubject<Carrito>;

  // Observable que los componentes pueden suscribirse
  carrito$;

  constructor() {
    const carritoGuardado = localStorage.getItem('carrito');
    if (carritoGuardado) {
      const obj = JSON.parse(carritoGuardado);
      this.carrito = new Carrito(obj.idCafeteria, obj.idReto, obj.nombreCupon,obj.kmObjetivo, obj.tiempoObjetivo, obj.productosCarrito || []);
    } else {
      this.carrito = new Carrito(0, null,null,null,null, []);
    }

    // Inicializamos BehaviorSubject con el carrito actual
    this.carritoSubject = new BehaviorSubject<Carrito>(this.carrito);
    this.carrito$ = this.carritoSubject.asObservable();
  }

  // Guardar carrito en localStorage y notificar cambios
  private actualizarCarrito() {
    localStorage.setItem('carrito', JSON.stringify(this.carrito));
    this.carritoSubject.next(this.carrito);
  }

  // Obtener carrito actual
  getCarrito(): Carrito {
    return this.carrito;
  }

  // Añadir producto al carrito
  anadirProducto(producto: ProductoCarrito, cantidad: number = 1) {
    const existing = this.carrito.productosCarrito.find(p => p.id === producto.id);
    if (existing) {
      existing.cantidad += cantidad;
    } else {
      this.carrito.productosCarrito.push({ ...producto, cantidad });
    }
    this.actualizarCarrito();
  }

  // Eliminar producto del carrito
  eliminarProducto(productoId: number, cantidad: number = 1) {
    const existing = this.carrito.productosCarrito.find(p => p.id === productoId);
    if (existing) {
      existing.cantidad -= cantidad;
      if (existing.cantidad <= 0) {
        this.carrito.productosCarrito = this.carrito.productosCarrito.filter(p => p.id !== productoId);
      }
      this.actualizarCarrito();
    }
  }

  // Devolver cantidad de un producto en el carrito
  devolverCantidadProducto(productoId: number): number {
    const existing = this.carrito.productosCarrito.find(p => p.id === productoId);
    return existing ? existing.cantidad : 0;
  }

  // Vaciar carrito completo
  vaciarCarrito() {
    this.carrito.productosCarrito = [];
    this.actualizarCarrito();
  }

  setIdCafeteria(idCafeteria: number) {
    // Si cambia la cafetería, vaciamos el carrito
    if (this.carrito.idCafeteria !== idCafeteria) {
      this.vaciarCarrito();
    }

    this.carrito.idCafeteria = idCafeteria;
    this.actualizarCarrito();
  }

  setIdReto(idReto: number | null) {
    this.carrito.idReto = idReto;
    this.actualizarCarrito();
  }

  setKmObjetivo(kmObjetivo: number | null) {
    this.carrito.kmObjetivo = kmObjetivo;
    this.actualizarCarrito()
  }

  getKmObjetivo() {
    return this.carrito.kmObjetivo;
  }

  setTiempoObjetivo(tiempoObjetivo: number) {
    this.carrito.tiempoObjetivo = tiempoObjetivo;
    this.actualizarCarrito();
  }

  getTiempoObjetivo() {
    return this.carrito.tiempoObjetivo;
  }
}
