package org.runffee.backend.modelos;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "cupon", catalog = "runffee", schema = "app")


//TERMINADO
public class Cupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column (name = "nombre")
    private String nombre;

    @Column (name = "fecha_caducidad")
    private Date fechaCaducidad;

    @Column (name = "tipo")
    @Enumerated(EnumType.ORDINAL)
    private TipoCupon tipo;

    @Column (name = "usado")
    private Boolean usado;

    @Column (name = "img")
    private String imagen;

    @Column (name = "porcentaje")
    private Integer porcentaje;

    @Column (name = "descripcion")
    private String descripcion;

    @Column (name = "eliminado")
    private Boolean eliminado;
}
