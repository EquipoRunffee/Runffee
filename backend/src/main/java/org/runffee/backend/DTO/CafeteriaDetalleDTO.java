package org.runffee.backend.DTO;

import lombok.Data;
import org.runffee.backend.modelos.TipoCafeteria;

@Data
public class CafeteriaDetalleCrearDTO {
    private String nombre;
    private String imagen;
    private TipoCafeteria tipoCafeteria;

    public CafeteriaDetalleCrearDTO(String nombre, String imagen, TipoCafeteria tipoCafeteria) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.tipoCafeteria = tipoCafeteria;
    }
}
