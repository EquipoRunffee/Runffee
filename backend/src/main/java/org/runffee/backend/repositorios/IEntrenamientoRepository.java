package org.runffee.backend.repositorios;

import org.runffee.backend.modelos.Entrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEntrenamientoRepository extends JpaRepository<Entrenamiento, Integer> {

    //Cuenta cuántos entrenamientos tiene el usuario con ese id
    Integer countByUsuarioId(Integer id);

}
