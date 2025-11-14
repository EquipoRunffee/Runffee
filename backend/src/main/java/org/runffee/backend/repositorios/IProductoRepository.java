package org.runffee.backend.repositorios;

import org.runffee.backend.modelos.Cafeteria;
import org.runffee.backend.modelos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByCafeteria(Cafeteria cafeteria);
}
