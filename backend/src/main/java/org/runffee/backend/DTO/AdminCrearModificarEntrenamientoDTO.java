package org.runffee.backend.DTO;


import java.time.LocalDateTime;
import lombok.Data;
/**
 * DTO con todos los datos del entrenamiento
 */
@Data
public class AdminCrearModificarEntrenamientoDTO {
    private String nombre;
    private LocalDateTime fecha_inicio;
    private LocalDateTime fecha_fin;
    private Double km_objetivo;
    private Integer tiempo_objetivo;
    private Boolean completado;
    private Boolean eliminado;

}
