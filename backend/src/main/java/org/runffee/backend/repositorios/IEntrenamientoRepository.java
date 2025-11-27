package org.runffee.backend.repositorios;

import org.runffee.backend.DTO.EntrenamientoDetalleDTO;
import org.runffee.backend.DTO.ValoracionDTO;
import org.runffee.backend.modelos.Entrenamiento;
import org.runffee.backend.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEntrenamientoRepository extends JpaRepository<Entrenamiento, Integer> {

    //Cuenta cuántos entrenamientos tiene el usuario con ese id
    Integer countByUsuarioId(Integer id);

    @Query(value = """
    SELECT e.nombre as nombre, e.fecha_fin as fecha_fin, e.strava_km as distancia, e.km_objetivo as km_objetivo
    FROM app.entrenamiento e
    JOIN app.usuario u ON u.id = e.id_usuario
    WHERE u.id = :idUsuario;
        """,
            nativeQuery = true)
    List<EntrenamientoDetalleDTO> obtenerEntrenamientoDetalles(@Param("idUsuario") Integer idUsuario);

    List<Entrenamiento> findByUsuarioId(Integer id);

    @Query(value = """
        SELECT EXISTS (SELECT 1 FROM app.entrenamiento e
        WHERE e.id_usuario = :idUsuario AND completado = false) AS existenEntrenamientosPendientes"""
    , nativeQuery = true)
    Boolean existenEntrenamientosPendientes(@Param("idUsuario") Integer idUsuario);



}
