package org.runffee.backend.repositorios;

import org.runffee.backend.DTO.PaginaCafeteriaDTO;
import org.runffee.backend.DTO.CafeteriaProductosDTO;
import org.runffee.backend.modelos.Cafeteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ICafeteriaRepository extends JpaRepository<Cafeteria, Integer> {

    @Query("SELECT c FROM Cafeteria c WHERE c.eliminado=false AND c.id = :idCafeteria")
    Cafeteria obtenerCafeteriaProductos(@Param("idCafeteria") Integer idCafeteria);


    @Query(value = """
    SELECT 
            id,
            nombre,
            descripcion,
            lat,
            lng,
            img AS imagen
    FROM app.cafeteria c
    WHERE id = :cafeteriaId
    """,
            nativeQuery = true)
    PaginaCafeteriaDTO obtenerInfoCafeteria(@Param("cafeteriaId")  Integer cafeteriaId);

}
