package org.runffee.backend.DTO;

import lombok.Data;
import org.runffee.backend.modelos.TipoCafeteria;

/**
 * DTO con todos los datos de la cafeteria
 */
@Data
public class CafeteriaDTO {
    private String nombre;
    private String descripcion;
    private Double lat;
    private Double lng;
    private String imagen;
    private TipoCafeteria tipoCafeteria;
    private Boolean eliminado;

}
