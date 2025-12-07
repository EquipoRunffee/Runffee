package org.runffee.backend.DTO;

import java.util.Date;
import lombok.Data;
/**
 * DTO con todos los datos del reto
 */
@Data
public class AdminCrearModificarRetoDTO {
    private String nombre;
    private String descripcion;
    private Date fecha_inicio;
    private Date fecha_fin;
    private Boolean eliminado;
}
