package org.runffee.backend.repositorios;

import org.runffee.backend.modelos.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPedidoRepository extends JpaRepository<Pedido, Integer> {
}
