package org.runffee.backend.DTO;

import lombok.Data;
import org.runffee.backend.modelos.TipoCafeteria;

/**
 * DTO para las Cards Cafeteria
 */
@Data
public class CafeteriaDetalleDTO {
    private String nombre;
    private String imagen;
    private TipoCafeteria tipoCafeteria;

    public CafeteriaDetalleDTO(String nombre, String imagen, TipoCafeteria tipoCafeteria) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.tipoCafeteria = tipoCafeteria;
    }
}
