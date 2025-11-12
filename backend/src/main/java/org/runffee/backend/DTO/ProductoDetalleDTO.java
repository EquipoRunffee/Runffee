package org.runffee.backend.DTO;

import lombok.Data;

@Data
public class ProductoDetalleCrearDTO {
    private String imagen;
    private String nombre;

    public ProductoDetalleCrearDTO(String imagen, String nombre) {
        this.imagen = imagen;
        this.nombre = nombre;
    }
}
