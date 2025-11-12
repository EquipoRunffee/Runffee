package org.runffee.backend.DTO;

import lombok.Data;
import org.runffee.backend.modelos.Cafeteria;

import java.math.BigDecimal;

@Data
public class ProductoCrearDTO {
    private String nombre;
    private String imagen;
    private BigDecimal precio;
    private String descripcion;
    private Boolean eliminado;
    private Cafeteria cafeteria;
}
