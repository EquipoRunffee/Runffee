package org.runffee.backend.DTO;

import lombok.Data;
import org.runffee.backend.modelos.TipoCupon;

import java.util.Date;

/**
 * DTO con todos los datos del cupon
 */
@Data
public class CuponDTO {
    private String nombre;
    private Date fechaCaducidad;
    private TipoCupon tipo;
    private Boolean usado;
    private String imagen;
    private Integer porcentaje;
    private String descripcion;
    private Boolean eliminado;
}
