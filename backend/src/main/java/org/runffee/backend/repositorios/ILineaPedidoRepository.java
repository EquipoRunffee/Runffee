package org.runffee.backend.repositorios;

import org.runffee.backend.modelos.LineaPedido;
import org.runffee.backend.modelos.Pedido;
import org.runffee.backend.modelos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILineaPedidoRepository extends JpaRepository<LineaPedido, Integer> {
    List<LineaPedido> findByProducto(Producto producto);

    LineaPedido findPedidoBy(Pedido pedido);
}
