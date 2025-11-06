package org.runffee.backend.DTO;

import lombok.Data;
import org.runffee.backend.modelos.TipoCafeteria;

@Data
public class CafeteriaCrearDTO {
    private String nombre;
    private String descripcion;
    private Double lat;
    private Double lng;
    private String imagen;
    private TipoCafeteria tipoCafeteria;
    private Boolean eliminado;

}
