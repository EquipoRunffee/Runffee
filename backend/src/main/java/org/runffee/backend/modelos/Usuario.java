package org.runffee.backend.modelos;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "usuario", catalog = "runffee", schema = "app")

//TERMINADA
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id;

    @Column (name = "nombre")
    private String nombre;

    @Column (name = "correo")
    private String correo;

    @Column (name = "contrasena")
    private String contrasena;

    @Column (name = "ciudad")
    private String ciudad;

    @Column (name = "pais")
    private String pais;

    @Column (name = "sexo")
    @Enumerated(EnumType.ORDINAL)
    private UsuarioSexo sexo;

    @Column (name = "role")
    @Enumerated(EnumType.ORDINAL)
    private UsuarioRole role;

    @Column (name = "imagen")
    private String imagen;

    @Column (name = "eliminado")
    private Boolean eliminado = Boolean.FALSE;

    @Column(name = "strava_athleteid")
    private Integer stravaAthleteId;

    @Column(name = "strava_accesstoken")
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
}
