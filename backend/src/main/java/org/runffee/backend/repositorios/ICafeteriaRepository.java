package org.runffee.backend.repositorios;

import org.runffee.backend.modelos.Cafeteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface ICafeteriaRepository extends JpaRepository<Cafeteria, Integer> {



}
