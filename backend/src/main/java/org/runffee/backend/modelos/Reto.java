package org.runffee.backend.modelos;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Primary;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "reto", catalog = "runffee", schema = "app")

public class Reto {
    //no fk
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column (name = "nombre")
    private String nome;

    @Column (name = "fecha_inicio")
    private Date fecha_inicio;

    @Column (name = "fecha_caducidad")
    private Date fecha_caducidad;

    @Column (name = "descripcion")
    private String descripcion;

    @Column (name = "eliminado")
    private Boolean eliminado;

}
