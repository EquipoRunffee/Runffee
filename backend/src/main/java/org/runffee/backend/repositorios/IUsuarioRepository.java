package org.runffee.backend.repositorios;

import org.runffee.backend.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    //Devuelve true si ya existe este correo
    Boolean existsByCorreo(String correo);

    //Devuelve true si ya existe este athlete id
    Boolean existsByStravaAthleteId(Integer stravaAthleteid);

    //Devuelve el Usuario con dicho athlete id
    Optional<Usuario> findByStravaAthleteId(Integer stravaAthleteid);

    Optional<Usuario> findByCorreo(String correo);
    Optional<Usuario> findByStravaAccessToken(String stravaAccessToken);

    @Query(value = "select u from Usuario u where u.refreshtoken = :refreshToken")
    Usuario obtenerUsuarioByRefreshToken(@Param("refreshToken") String refreshToken);
}
