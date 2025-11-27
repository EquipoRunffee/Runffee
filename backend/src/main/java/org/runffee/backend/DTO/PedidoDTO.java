package org.runffee.backend.DTO;

import lombok.Data;
import org.runffee.backend.modelos.EstadoPedido;
import org.runffee.backend.modelos.Valoracion;

import java.math.BigDecimal;

/**
 * DTO con todos los datos del pedido
 */
@Data
public class PedidoDTO {
    private Valoracion valoracion;
    private String cuponAplicado;
    private Double precioTotal;
    private String qr;
    private EstadoPedido estado;
    private Boolean eliminado;
}
