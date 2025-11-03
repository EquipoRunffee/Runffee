package org.runffee.backend.repositorios;

import org.runffee.backend.modelos.Entrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEntrenamientoRepository extends JpaRepository<Entrenamiento, Integer> {
}
