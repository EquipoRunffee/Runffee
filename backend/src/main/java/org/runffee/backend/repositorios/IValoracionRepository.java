package org.runffee.backend.repositorios;

import org.runffee.backend.DTO.PaginaCafeteriaDTO;
import org.runffee.backend.DTO.ValoracionDTO;
import org.runffee.backend.modelos.Cafeteria;
import org.runffee.backend.modelos.Pedido;
import org.runffee.backend.modelos.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface IValoracionRepository extends JpaRepository<Valoracion, Integer> {

    @Query(value = """
    SELECT SUM(v.cantidad) / COUNT(v.cantidad) AS total
    FROM app.valoracion v
    JOIN app.pedido p ON p.id_valoracion = v.id
    JOIN app.lineapedido lp ON lp.id_pedido = p.id
    JOIN app.producto pr ON pr.id = lp.id_producto
    JOIN app.cafeteria c ON c.id = pr.id_cafeteria
    WHERE c.id = :cafeteriaId
    """,
            nativeQuery = true)
    BigDecimal obtenerMediaValoracionCafeteria(@Param("cafeteriaId") Integer cafeteriaId);

    @Query(value = """
       SELECT v.*, c.nombre AS nombreCafeteria
       FROM app.valoracion v
       JOIN app.pedido pe ON pe.id_valoracion = v.id
       JOIN app.entrenamiento en ON en.id_pedido = pe.id
       JOIN app.usuario u ON u.id = en.id_usuario
       JOIN app.lineapedido l ON l.id_pedido = pe.id
       JOIN app.producto p ON p.id = l.id_producto
       JOIN app.cafeteria c ON c.id = p.id_cafeteria
       WHERE u.id = :idUsuario;
        """,
            nativeQuery = true)
    List<ValoracionDTO> obtenerValoracionEntrenamiento(@Param("idUsuario") Integer idUsuario);

    @Query(value = """
        SELECT DISTINCT 
                    v.id,
                    v.titulo,
                    v.cantidad,
                    v.descripcion
        FROM app.valoracion v
        JOIN app.pedido p ON p.id_valoracion = v.id
        JOIN app.lineapedido lp ON lp.id_pedido = p.id
        JOIN app.producto pr ON pr.id = lp.id_producto
        WHERE p.id_cafeteria = :cafeteriaId
        
    """,
            nativeQuery = true)
    List<ValoracionDTO> obtenerTodasValoracionesCafeteria(@Param("cafeteriaId") Integer cafeteriaId);

}
