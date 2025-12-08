package org.runffee.backend.modelos;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "usuario", catalog = "runffee_0tzu", schema = "app")

//TERMINADA
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id;

    @Column (name = "nombre")
    private String nombre;

    @Column (name = "apellidos")
    private String apellidos;

    @Column (name = "correo", unique = true)
    private String correo;

    @Column (name = "contrasena")
    private String contrasena;

    @Column (name = "ciudad")
    private String ciudad;

    @Column (name = "pais")
    private String pais;

    @Column (name = "sexo")
    private String sexo;

    @Column (name = "role")
    @Enumerated(EnumType.ORDINAL)
    private UsuarioRole role;

    @Column (name = "img")
    private String imagen;

    @Column (name = "eliminado")
    private Boolean eliminado = Boolean.FALSE;

    @Column(name = "strava_athleteid")
    private Integer stravaAthleteId;

    @Column(name = "strava_accesstoken", unique = true)
    private String stravaAccessToken;

    @Column(name = "strava_refreshtoken")
    private String stravaRefreshToken;

    @Column (name = "strava_expiresat")
    private Instant stravaExpiresAt;

    @Column (name = "accesstoken")
    private String accesstoken;

    @Column (name = "refreshtoken")
    private String refreshtoken;

    @Column (name = "expiresat")
    private Instant expiresat;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return correo;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
