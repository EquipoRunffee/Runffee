package org.runffee.backend.repositorios;

import org.runffee.backend.modelos.LineaPedido;
import org.runffee.backend.modelos.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPedidoRepository extends JpaRepository<Pedido, Integer> {
}
