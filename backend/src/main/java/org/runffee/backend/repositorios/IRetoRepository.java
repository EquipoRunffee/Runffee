package org.runffee.backend.repositorios;

import org.runffee.backend.modelos.Reto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRetoRepository extends JpaRepository<Reto, Integer> {
}
