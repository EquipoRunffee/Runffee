package org.runffee.backend.DTO;

import lombok.Data;
import org.runffee.backend.modelos.Pedido;
import org.runffee.backend.modelos.Usuario;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * DTO con todos los datos del entrenamiento
 */
@Data
public class EntrenamientoDTO {
    private String nombre;
    private LocalDateTime fecha_inicio;
    private LocalDateTime fecha_fin;
    private String url_mapa;
    private String descripcion;
    private Double strava_km;
    private Double km_objetivo;
    private Integer strava_tiempo;
    private Integer tiempo_objetivo;
    private Boolean eliminado;
    private Usuario usuario;
    private Pedido pedido;
}
