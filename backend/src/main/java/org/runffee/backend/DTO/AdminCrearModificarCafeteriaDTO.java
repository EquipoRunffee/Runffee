package org.runffee.backend.DTO;

import org.runffee.backend.modelos.TipoCafeteria;

import lombok.Data;

/**
 * DTO con todos los datos de la cafeteria
 */
@Data
public class AdminCrearModificarCafeteriaDTO {
    private String nombre;
    private String descripcion;
    private Double lat;
    private Double lng;
    private String imagen;
    private TipoCafeteria tipoCafeteria;
    private Boolean eliminado;
}
