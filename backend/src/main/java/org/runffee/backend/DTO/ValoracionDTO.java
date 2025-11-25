package org.runffee.backend.DTO;

import lombok.Data;
import org.runffee.backend.modelos.Valoracion;

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
    private String nombreCafeteria;

    public ValoracionDTO(String titulo, BigDecimal cantidad, String descripcion, Boolean eliminado, String nombreCafeteria) {
        this.titulo = titulo;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.eliminado = eliminado;
        this.nombreCafeteria = nombreCafeteria;
    }
}
