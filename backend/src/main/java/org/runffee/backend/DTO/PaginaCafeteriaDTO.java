package org.runffee.backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.runffee.backend.modelos.Producto;
import org.runffee.backend.modelos.Valoracion;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginaCafeteriaDTO {
    private String nombre;
    private String descripcion;
    private Double lat;
    private Double lng;
    private String imagen;
    private List<ProductoCafeteriaDTO> productos;
    private List<ValoracionCafeteriaDTO> valoraciones;


}
