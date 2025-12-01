package org.runffee.backend.modelos;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Primary;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "entrenamiento", catalog = "runffee_0tzu", schema = "app")

//TERMINADO
public class Entrenamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column (name = "id_strava")
    private Integer idStrava;

    @Column (name = "strava_km")
    private Double stravaKm;

    @Column (name = "strava_tiempo")
    private Integer stravaTiempo;

    @Column (name = "nombre")
    private String nombre;

    @Column (name = "fecha_inicio")
    private LocalDateTime fecha_inicio;

    @Column (name = "fecha_fin")
    private LocalDateTime fecha_fin;

    @Column (name = "url_mapa")
    private String url_mapa;

    @Column (name = "descripcion")
    private String descripcion;

    @Column (name = "km_objetivo")
    private Double kmObjetivo;

    @Column (name = "tiempo_objetivo")
    private Integer tiempoObjetivo;

    @Column(name = "completado")
    private Boolean completado;

    @Column (name = "eliminado")
    private Boolean eliminado;

    @JoinColumn(name = "id_usuario")
    @ManyToOne
    private Usuario usuario;

    @JoinColumn(name = "id_pedido")
    @OneToOne
    private Pedido pedido;

    @JoinColumn(name = "id_reto")
    @OneToOne
    private Reto reto;

    @JoinColumn(name = "id_cupon")
    @OneToOne
    private Cupon cupon;
}
