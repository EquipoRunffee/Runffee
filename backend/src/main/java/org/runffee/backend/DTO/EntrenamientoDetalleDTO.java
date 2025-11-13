package org.runffee.backend.DTO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * DTO para la Card de Entrenamiento
 */
@Data
public class EntrenamientoDetalleDTO {
    private String nombre;
    private BigDecimal distancia;
    private Date fecha_fin;

    public EntrenamientoDetalleDTO(String nombre, BigDecimal distancia, Date fecha_fin) {
        this.nombre = nombre;
        this.distancia = distancia;
        this.fecha_fin = fecha_fin;
    }

}
