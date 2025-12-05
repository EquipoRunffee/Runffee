package org.runffee.backend.DTO;

import org.runffee.backend.modelos.Pedido;
import org.runffee.backend.modelos.Usuario;

import java.time.LocalDateTime;

public class AdminCrearModificarEntrenamientoDTO {
    private String nombre;
    private LocalDateTime fecha_inicio;
    private LocalDateTime fecha_fin;
    private Double km_objetivo;
    private Integer tiempo_objetivo;
    private Boolean eliminado;

}
