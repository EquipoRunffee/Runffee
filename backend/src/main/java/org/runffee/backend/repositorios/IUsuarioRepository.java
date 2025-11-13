package org.runffee.backend.repositorios;

import org.runffee.backend.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    //busca por email (comprobar que no esta ya registrado en runffee)
    Usuario findByEmail(String email);

    //busca por id de Strava (para redirigir a login o register)
    Optional<Usuario> findByAthleteid(Integer athleteid);
}
