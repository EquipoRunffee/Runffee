package org.runffee.backend.repositorios;

import org.runffee.backend.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
}
