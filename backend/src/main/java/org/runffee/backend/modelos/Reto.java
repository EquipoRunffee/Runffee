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
@Table(name = "reto", catalog = "runffee_0tzu", schema = "app")

//TERMINADO
public class Reto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column (name = "nombre")
    private String nombre;

    @Column (name = "fecha_inicio")
    private Date fecha_inicio;

    @Column (name = "fecha_fin")
    private Date fecha_fin;

    @Column (name = "descripcion")
    private String descripcion;

    @Column (name = "km")
    private Double km;

    @Column (name = "tiempo")
    private Integer tiempo;

    @Column (name = "eliminado")
    private Boolean eliminado;
}
