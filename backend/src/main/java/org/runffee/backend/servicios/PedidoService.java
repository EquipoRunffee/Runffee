package org.runffee.backend.servicios;

import org.runffee.backend.DTO.CrearPedidoDTO;
import org.runffee.backend.DTO.PedidoDTO;
import org.runffee.backend.DTO.ProductoCarritoDTO;
import org.runffee.backend.modelos.*;
import org.runffee.backend.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class PedidoService {

    @Autowired
    private IPedidoRepository pedidoRepository;

    @Autowired
    private IProductoRepository productoRepository;

    @Autowired
    private ILineaPedidoRepository lineaPedidoRepository;

    @Autowired
    private ICuponRepository cuponRepository;

    @Autowired
    private IRetoRepository reitoRepository;

    @Autowired
    private IEntrenamientoRepository entrenamientoRepository;

    /**
     * Función que devuelve todos los pedidos
     * @return
     */
    public List<Pedido> obtenerPedidos() {
        return pedidoRepository.findAll()
                .stream()
                .filter(pedido -> !pedido.getEliminado())
                .toList();
    }

    /**
     * Función que devuelve el pedido por id
     * @param id
     * @return
     */
    public Pedido obtenerPedido(int id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    /**
     * Función para crear un nuevo pedido
     * @param pedido
     */
    public void crearPedido(PedidoDTO pedido) {
        Pedido nuevoPedido = new Pedido();

        nuevoPedido.setCuponAplicado(pedido.getCuponAplicado());
        nuevoPedido.setPrecioTotal(pedido.getPrecioTotal());
        nuevoPedido.setQr(pedido.getQr());
        nuevoPedido.setEstado(pedido.getEstado());

        pedidoRepository.save(nuevoPedido);
    }

    /**
     * Función para eliminar un pedido
     * @param id
     */
    public void eliminarPedido(int id) {
        Pedido pedido = pedidoRepository.findById(id).orElse(null);
        if (pedido != null) {
            pedido.setEliminado(true);
        }
    }

    public ResponseEntity<?> crearPedidoCarrito(CrearPedidoDTO carrito, Usuario usuario) {

        if(entrenamientoRepository.existenEntrenamientosPendientes(usuario.getId())){
            return ResponseEntity.ok(Map.of("Forbidden", "Hay un entrenamiento pendiente."));
        }

        Entrenamiento entrenamiento = new Entrenamiento();
        entrenamiento.setUsuario(usuario);
        Pedido pedido = new Pedido();

        if(carrito.getNombreCupon() != null && !carrito.getNombreCupon().isEmpty()){
            pedido.setCuponAplicado(carrito.getNombreCupon());
            Cupon cuponUsado = cuponRepository.findByNombre(carrito.getNombreCupon());
            cuponUsado.setUsado(true);
            cuponRepository.save(cuponUsado);
        }

        Double precioTotal = 0.0;

        for (ProductoCarritoDTO producto : carrito.getProductosCarrito()){
            precioTotal += productoRepository.findById(producto.getId()).get().getPrecio() * producto.getCantidad();
        }

        pedido.setPrecioTotal(precioTotal);
        pedido.setEstado(EstadoPedido.PENDIENTE);
        pedido.setEliminado(false);
        pedidoRepository.save(pedido);

        System.out.println(carrito.getTiempoObjetivo());
        System.out.println(carrito.getKmObjetivo());
        if(carrito.getIdReto() == null && carrito.getKmObjetivo() != null && carrito.getTiempoObjetivo() != null &&
                carrito.getKmObjetivo() > 0 && carrito.getTiempoObjetivo() > 0){
            entrenamiento.setKmObjetivo(carrito.getKmObjetivo());
            entrenamiento.setTiempoObjetivo(carrito.getTiempoObjetivo());
        } else if (carrito.getIdReto() != null) {
            Reto reto = reitoRepository.findById(carrito.getIdReto()).get();
            entrenamiento.setReto(reto);
            entrenamiento.setKmObjetivo(reto.getKm());
            entrenamiento.setTiempoObjetivo(reto.getTiempo());
        } else{
            return ResponseEntity.ok(Map.of("Forbidden", "No se pudo crear el objetivo."));
        }

        entrenamiento.setPedido(pedido);
        entrenamiento.setCompletado(false);
        entrenamiento.setEliminado(false);
        entrenamiento.setFecha_inicio(LocalDateTime.now());
        entrenamientoRepository.save(entrenamiento);

        for (ProductoCarritoDTO producto : carrito.getProductosCarrito()){
            LineaPedido linea = new LineaPedido();
            linea.setProducto(productoRepository.findById(producto.getId()).get());
            linea.setCantidadProducto(producto.getCantidad());
            linea.setPedido(pedido);
            linea.setEliminado(false);
            lineaPedidoRepository.save(linea);
        }

        return ResponseEntity.ok("Pedido creado correctamente");
    }

    public ResponseEntity<?> entregarPedido(Integer idPedido, Usuario usuario) {
        Pedido pedido = pedidoRepository.findById(idPedido).orElse(null);
        if (pedido == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Forbidden", "No se encontro el pedido."));
        }

        pedido.setEstado(EstadoPedido.ENTREGADO);
        pedidoRepository.save(pedido);
        return ResponseEntity.ok(Map.of("estado", EstadoPedido.ENTREGADO));
    }
}
