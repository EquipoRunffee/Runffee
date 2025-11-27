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
@Table(name = "entrenamiento", catalog = "runffee", schema = "app")

//TERMINADO
public class Entrenamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column (name = "id_strava")
    private Integer idStrava;

    @Column (name = "nombre")
    private String nombre;

    @Column (name = "fecha_inicio")
    private Date fecha_inicio;

    @Column (name = "fecha_fin")
    private Date fecha_fin;

    @Column (name = "url_mapa")
    private String url_mapa;

    @Column (name = "descripcion")
    private String descripcion;

    @Column (name = "strava_km")
    private Double strava_km;

    @Column (name = "km_objetivo")
    private Double km_objetivo;

    @Column (name = "strava_tiempo")
    private Integer strava_tiempo;

    @Column (name = "tiempo_objetivo")
    private Integer tiempo_objetivo;

    @Column (name = "eliminado")
    private Boolean eliminado;

    @JoinColumn(name = "id_usuario")
    @ManyToOne
    private Usuario usuario;

    @JoinColumn(name = "id_pedido")
    @OneToOne
    private Pedido pedido;
}
