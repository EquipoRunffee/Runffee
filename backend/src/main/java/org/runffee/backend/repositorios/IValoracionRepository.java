package org.runffee.backend.repositorios;

import org.runffee.backend.modelos.Pedido;
import org.runffee.backend.modelos.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IValoracionRepository extends JpaRepository<Valoracion, Integer> {
    List<Valoracion> findByPedidos(Pedido pedido);
}
