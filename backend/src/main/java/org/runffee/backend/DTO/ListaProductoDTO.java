package org.runffee.backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.runffee.backend.modelos.TipoProducto;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaProductoDTO {
    private Integer id;
    private String nombre;
    private String imagen;
    private String descripcion;
    private TipoProducto tipo;
    private BigDecimal precio;
}
