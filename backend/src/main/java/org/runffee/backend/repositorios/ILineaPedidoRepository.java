package org.runffee.backend.repositorios;

import org.runffee.backend.modelos.LineaPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILineaPedidoRepository extends JpaRepository<LineaPedido, Integer> {
}
