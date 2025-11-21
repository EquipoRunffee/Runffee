package org.runffee.backend.repositorios;

import org.runffee.backend.modelos.Entrenamiento;
import org.runffee.backend.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEntrenamientoRepository extends JpaRepository<Entrenamiento, Integer> {

    //Cuenta cuántos entrenamientos tiene el usuario con ese id
    Integer countByUsuarioId(Integer id);
    List<Entrenamiento> findByUsuarioId(Integer id);
}
