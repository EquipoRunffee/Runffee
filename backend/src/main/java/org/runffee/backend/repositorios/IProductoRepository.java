package org.runffee.backend.repositorios;

import org.runffee.backend.DTO.ListaProductoDTO;
import org.runffee.backend.modelos.Cafeteria;
import org.runffee.backend.modelos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByCafeteria(Cafeteria cafeteria);

    @Query("SELECT pr FROM Producto pr WHERE pr.cafeteria.id = :idCafeteria AND pr.eliminado=false")
    List<Producto> obtenerListaProductosCafeteria(@Param("idCafeteria") Integer idCafeteria);

}
