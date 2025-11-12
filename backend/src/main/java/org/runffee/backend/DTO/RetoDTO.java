package org.runffee.backend.DTO;

import lombok.Data;
import org.runffee.backend.modelos.Entrenamiento;

import java.util.Date;

/**
 * DTO con todos los datos del reto
 */
@Data
public class RetoDTO {
    private String nombre;
    private Date fecha_inicio;
    private Date fecha_caducidad;
    private String descripcion;
    private Boolean eliminado;
    private Entrenamiento entrenamiento;
}
