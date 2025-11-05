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
@Table(name = "producto", catalog = "runffee", schema = "app")


//TERMINADO
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column (name = "nombre")
    private String nome;

    @Column (name = "imagen")
    private String imagen;

    @Column (name = "precio")
    private BigDecimal precio;

    @Column (name = "descripcion")
    private String descripcion;

    @Column (name = "eliminado")
    private Boolean eliminado;

    @JoinColumn (name = "id_cafeteria")
    @ManyToOne
    private Cafeteria cafeteria;

}
