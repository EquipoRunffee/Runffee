package org.runffee.backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.runffee.backend.modelos.Valoracion;

import java.math.BigDecimal;

/**
 * DTO con todos los datos de la valoracion
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValoracionDTO {
    private String titulo;
    private BigDecimal cantidad;
    private String descripcion;
    private Boolean eliminado;
    private String nombreCafeteria;



}
