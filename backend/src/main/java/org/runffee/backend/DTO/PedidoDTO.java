package org.runffee.backend.DTO;

import lombok.Data;
import org.runffee.backend.modelos.EstadoPedido;
import org.runffee.backend.modelos.Valoracion;

import java.math.BigDecimal;

@Data
public class PedidoCrearDTO {
    private Valoracion valoracion;
    private String cuponAplicado;
    private BigDecimal precioTotal;
    private String qr;
    private EstadoPedido estado;
    private Boolean eliminado;
}
