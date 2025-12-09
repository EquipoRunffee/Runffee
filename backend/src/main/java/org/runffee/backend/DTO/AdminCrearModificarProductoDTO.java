package org.runffee.backend.DTO;

import lombok.Data;
import org.runffee.backend.modelos.TipoProducto;

/**
 * DTO con datos para poder crear / modificar o eliminar un producto
 */
@Data
public class AdminCrearModificarProductoDTO {
    private String descripcion;
    private Boolean eliminado;
    private Integer idCafeteria;
    private String imagen;
    private String nombre;
    private Double precio;
    private TipoProducto tipoProducto;
}
