package org.runffee.backend.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.runffee.backend.modelos.Entrenamiento;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * DTO para la Card de Entrenamiento
 */
@Data
public class EntrenamientoDetalleDTO {
    private Integer id;
    private String nombre;
    private LocalDate fecha_fin;
    private Double stravaKm;
    private Integer stravaTiempo;
    private Boolean completado;

    public EntrenamientoDetalleDTO(Integer id, String nombre, Timestamp fecha_fin, BigDecimal stravaKm, Integer stravaTiempo, Boolean completado) {
        this.id = id;
        this.nombre = nombre;
        if(fecha_fin != null) {
            this.fecha_fin = fecha_fin.toLocalDateTime().toLocalDate();
        }
        if(stravaKm != null) {
            this.stravaKm = stravaKm.doubleValue();
        }
        this.stravaTiempo = stravaTiempo;
        this.completado = completado;
    }
}
