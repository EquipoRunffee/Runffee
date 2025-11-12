package org.runffee.backend.DTO;

import lombok.Data;
import java.util.Date;

/**
 * DTO con todos los datos del cupon
 */
@Data
public class CuponDTO {
    private String nombre;
    private Date fechaCaducidad;
    private Integer tipo;
    private Boolean usado;
    private String imagen;
    private Integer porcentaje;
    private String descripcion;
    private Boolean eliminado;
}
