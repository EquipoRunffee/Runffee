package org.runffee.backend.modelos;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Primary;

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
    private String nome;

    @Column (name = "correo")
    private String correo;

    @Column (name = "contrasena")
    private String contrasena;

    @Column (name = "ciudad")
    private String ciudad;

    @Column (name = "pais")
    private String pais;

    @Column (name = "sexo")
    private Integer sexo;

    @Column (name = "imagen")
    private String imagen;

    @Column (name = "eliminado")
    private Boolean eliminado;
}
