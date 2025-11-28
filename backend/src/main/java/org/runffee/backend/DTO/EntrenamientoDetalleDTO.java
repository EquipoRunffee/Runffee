package org.runffee.backend.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

/**
 * DTO para la Card de Entrenamiento
 */
@Data
public class EntrenamientoDetalleDTO {
    private String nombre;
    private Double strava_km;
    private Double km_objetivo;
    private LocalDate fecha_fin;

    public EntrenamientoDetalleDTO(String nombre, Double strava_km, Double objetivo_km,LocalDate fecha_fin) {
        this.nombre = nombre;
        this.strava_km = strava_km;
        this.km_objetivo = objetivo_km;
        this.fecha_fin = fecha_fin;
    }

}
