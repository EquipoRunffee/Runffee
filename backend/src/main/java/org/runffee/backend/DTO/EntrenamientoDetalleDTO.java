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
    private Double strava_km;
    private Double objetivo_km;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha_fin;

    public EntrenamientoDetalleDTO(String nombre, Double strava_km, Double objetivo_km,Date fecha_fin) {
        this.nombre = nombre;
        this.strava_km = strava_km;
        this.objetivo_km = objetivo_km;
        this.fecha_fin = fecha_fin;
    }

}
