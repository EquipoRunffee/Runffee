package org.runffee.backend.repositorios;

import org.runffee.backend.modelos.Cupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICuponRepository extends JpaRepository<Cupon, Integer> {
    Cupon findByNombre(String nombre);

    boolean existsByNombre(String nombre);

    @Query(value = """
        select c.*
        from app.cupon c
        join app.entrenamiento e on e.id_cupon = c.id
        join app.usuario u on u.id = e.id_usuario
        where u.id = :idUsuario
        """,
            nativeQuery = true)
    List<Cupon> obtenerCuponPorUsuario(@Param("idUsuario") Integer idUsuario);

}
