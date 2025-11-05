package org.runffee.backend.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ValoracionCrearDTO {
    private String titulo;
    private BigDecimal cantidad;
    private String descripcion;
    private Boolean eliminado;
}
