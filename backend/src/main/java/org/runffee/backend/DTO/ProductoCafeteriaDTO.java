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
public class ProductoCafeteriaDTO {
    private Integer id_producto;
    private String nombre_producto;
    private String imagen_producto;
    private Long vendido;

}
