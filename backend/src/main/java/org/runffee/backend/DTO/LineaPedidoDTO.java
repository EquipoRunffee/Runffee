package org.runffee.backend.DTO;

import lombok.Data;
import org.runffee.backend.modelos.Pedido;
import org.runffee.backend.modelos.Producto;

/**
 * DTO con todos los datos de linea pedido
 */
@Data
public class LineaPedidoDTO {
    private Integer cantidadProducto;
    private Boolean eliminado;
    private Producto producto;
    private Pedido pedido;
}
