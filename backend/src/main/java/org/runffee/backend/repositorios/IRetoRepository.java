package org.runffee.backend.repositorios;

import org.runffee.backend.modelos.Reto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRetoRepository extends JpaRepository<Reto, Integer> {

    @Query("""
SELECT r
FROM Reto r
WHERE r.eliminado = false
  AND NOT EXISTS (
      SELECT e
      FROM Entrenamiento e
      WHERE e.reto.id = r.id AND e.usuario.id = :idUsuario
  )
""")
    List<Reto> obtenerRetosDisponiblesUsuario(@Param("idUsuario") Integer idUsuario);
}
