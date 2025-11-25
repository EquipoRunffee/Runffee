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
}
