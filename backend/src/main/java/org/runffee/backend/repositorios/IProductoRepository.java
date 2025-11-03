package org.runffee.backend.repositorios;

import org.runffee.backend.modelos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto, Integer> {
}
