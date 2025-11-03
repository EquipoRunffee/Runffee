package org.runffee.backend.repositorios;

import org.runffee.backend.modelos.Cupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICuponRepository extends JpaRepository<Cupon, Integer> {
}
