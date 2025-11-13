package org.runffee.backend.DTO;

import lombok.Data;
import org.runffee.backend.modelos.TipoCafeteria;
import org.runffee.backend.servicios.ValoracionService;

import java.math.BigDecimal;

@Data
public class CafeteriaDetalleCrearDTO {
    private String nombre;
    private String imagen;
    private TipoCafeteria tipoCafeteria;
    private BigDecimal valoracionMedia;


    public CafeteriaDetalleCrearDTO(String nombre, String imagen, TipoCafeteria tipoCafeteria,  BigDecimal valoracionMedia) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.tipoCafeteria = tipoCafeteria;
        this.valoracionMedia =  valoracionMedia;
    }
}
