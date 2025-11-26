package org.runffee.backend.repositorios;

import org.runffee.backend.DTO.EntrenamientoDetalleDTO;
import org.runffee.backend.DTO.ValoracionDTO;
import org.runffee.backend.modelos.Entrenamiento;
import org.runffee.backend.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEntrenamientoRepository extends JpaRepository<Entrenamiento, Integer> {

    //Cuenta cuántos entrenamientos tiene el usuario con ese id
    Integer countByUsuarioId(Integer id);
    List<Entrenamiento> findByUsuarioId(Integer id);
}
