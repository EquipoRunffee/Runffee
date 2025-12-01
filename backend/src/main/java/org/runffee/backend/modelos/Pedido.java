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
@Table(name = "pedido", catalog = "runffee_0tzu", schema = "app")

//TERMINADO
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "id_valoracion")
    @OneToOne
    private Valoracion valoracion;

    @Column (name = "cupon_aplicado")
    private String cuponAplicado;

    @Column (name = "precio_total")
    private Double precioTotal;

    @Column (name = "qr")
    private String qr;

    @Column (name = "estado")
    @Enumerated(EnumType.ORDINAL)
    private EstadoPedido estado;

    @Column (name = "eliminado")
    private Boolean eliminado;
}
