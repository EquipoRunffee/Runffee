package org.runffee.backend.DTO;

import lombok.Data;

import java.math.BigDecimal;

/**
 * DTO con todos los datos de la valoracion
 */
@Data
public class ValoracionDTO {
    private String titulo;
    private BigDecimal cantidad;
    private String descripcion;
    private Boolean eliminado;
}
