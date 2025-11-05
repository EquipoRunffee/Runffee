package org.runffee.backend.modelos;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Primary;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "valoracion", catalog = "runffee", schema = "app")

//TERMINADO
public class Valoracion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column (name = "titulo")
    private String titulo;

    @Column (name = "cantidad")
    private BigDecimal cantidad;

    @Column (name = "descripcion")
    private String descripcion;

    @Column (name = "eliminado")
    private Boolean eliminado;
}
