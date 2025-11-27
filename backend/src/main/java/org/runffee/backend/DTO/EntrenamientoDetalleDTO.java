package org.runffee.backend.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha_fin;

    public EntrenamientoDetalleDTO(String nombre, BigDecimal distancia, Date fecha_fin) {
        this.nombre = nombre;
        this.distancia = distancia;
        this.fecha_fin = fecha_fin;
    }

}
