package org.runffee.backend.repositorios;

import org.runffee.backend.modelos.Cafeteria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICafeteriaRepository extends JpaRepository<Cafeteria, Integer> {
}
