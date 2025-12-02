package org.runffee.backend.repositorios;

import org.runffee.backend.DTO.EntrenamientoDetalleDTO;
import org.runffee.backend.DTO.EntrenamientoPerfilDTO;
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

    Boolean existsEntrenamientoByIdStrava(Integer idStrava);

    @Query(value = """
    SELECT e.id as id, e.nombre as nombre, e.fecha_fin as fecha_fin, e.strava_km as stravaKm, e.strava_tiempo as stravaTiempo, e.completado as completado 
    FROM app.Entrenamiento e 
    WHERE e.id_usuario = :idUsuario
    ORDER BY e.id DESC
        """, nativeQuery = true)
    List<EntrenamientoDetalleDTO> obtenerEntrenamientoDetalles(@Param("idUsuario") Integer idUsuario);

    List<Entrenamiento> findByUsuarioId(Integer id);

    @Query(value = """
        SELECT EXISTS (SELECT 1 FROM app.entrenamiento e
        WHERE e.id_usuario = :idUsuario AND completado = false) AS existenEntrenamientosPendientes"""
    , nativeQuery = true)
    Boolean existenEntrenamientosPendientes(@Param("idUsuario") Integer idUsuario);

    @Query("""
        SELECT e.nombre, e.descripcion, e.completado, e.stravaKm, e.stravaTiempo, e.url_mapa
        FROM Entrenamiento e WHERE e.id = :idEntrenamiento AND e.usuario.id = :idUsuario""")
    EntrenamientoPerfilDTO obtenerEntrenamientoPerfil(@Param("idEntrenamiento") Integer idEntrenamiento, @Param("idUsuario") Integer idUsuario);
}
