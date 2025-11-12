package org.runffee.backend.DTO;

import lombok.Data;
import java.util.Date;

@Data
public class CuponCrearDTO {
    private String nombre;
    private Date fechaCaducidad;
    private Integer tipo;
    private Boolean usado;
    private String imagen;
    private Integer porcentaje;
    private String descripcion;
    private Boolean eliminado;
}
