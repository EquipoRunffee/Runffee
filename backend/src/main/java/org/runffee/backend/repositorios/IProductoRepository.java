package org.runffee.backend.repositorios;

import org.runffee.backend.DTO.ProductoCafeteriaDTO;
import org.runffee.backend.DTO.ListaProductoDTO;
import org.runffee.backend.modelos.Cafeteria;
import org.runffee.backend.modelos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface IProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByCafeteria(Cafeteria cafeteria);

    @Query(value = "SELECT pr FROM Producto pr WHERE pr.cafeteria.id = :idCafeteria AND pr.eliminado=true ")
    List<ListaProductoDTO> obtenerListaProductosCafeteria(@Param("idCafeteria") Integer idCafeteria);

    @Query(value = """
    select
            p.id AS id_producto,
        p.nombre AS nombre_producto,
        p.img as imagen_producto,
        COUNT(*) AS vendido
    from app.lineapedido lp
    join app.producto p on lp.id_producto = p.id 
    where p.id_cafeteria = :cafeteriaId
    group by p.id, p.nombre, p.img order by vendido desc
    limit 4
    """,
            nativeQuery = true)
    List<ProductoCafeteriaDTO> productosMasVendidos(@Param("cafeteriaId") Integer cafeteriaId);
}
