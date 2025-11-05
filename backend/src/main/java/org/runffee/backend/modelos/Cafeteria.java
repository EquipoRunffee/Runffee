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
@Table(name = "cafeteria", catalog = "runffee", schema = "app")

public class Cafeteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id;

    @Column (name = "nombre")
    private String nome;

    @Column (name = "descripcion")
    private String descripcion;

    @Column (name = "lat")
    private Double lat;

    @Column (name = "lng")
    private Double lng;

    @Column (name = "imagen")
    private String imagen;

    @Column (name = "eliminado")
    private Boolean eliminado;
}
