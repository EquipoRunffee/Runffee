package org.runffee.backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CafeteriaProductosDTO {
    private Integer id;
    private String nombre;
    private String imagen;
    private List<ListaProductoDTO> productos;

    public CafeteriaProductosDTO(Integer id, String nombre, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
    }
}
