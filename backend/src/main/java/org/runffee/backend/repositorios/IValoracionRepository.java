package org.runffee.backend.repositorios;

import org.runffee.backend.modelos.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IValoracionRepository extends JpaRepository<Valoracion, Integer> {
}
