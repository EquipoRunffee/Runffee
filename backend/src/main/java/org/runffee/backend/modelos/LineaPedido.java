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
@Table(name = "lineapedido", catalog = "runffee_0tzu", schema = "app")


//TERMINADO
public class LineaPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "id_producto")
    @ManyToOne
    private Producto producto;

    @JoinColumn (name = "id_pedido")
    @ManyToOne
    private Pedido pedido;

    @Column (name = "cantidad_producto")
    private Integer cantidadProducto;

    @Column (name = "eliminado")
    private Boolean eliminado;
}
