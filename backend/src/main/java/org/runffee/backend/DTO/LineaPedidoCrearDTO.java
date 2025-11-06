package org.runffee.backend.DTO;

import lombok.Data;
import org.runffee.backend.modelos.Pedido;
import org.runffee.backend.modelos.Producto;

@Data
public class LineaPedidoCrearDTO {
    private Integer cantidadProducto;
    private Boolean eliminado;
    private Producto producto;
    private Pedido pedido;
}
