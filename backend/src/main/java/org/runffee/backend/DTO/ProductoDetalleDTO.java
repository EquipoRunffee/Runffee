package org.runffee.backend.DTO;

import lombok.Data;

/**
 * DTO para el componente Producto en el carrito de compra
 */
@Data
public class ProductoDetalleDTO {
    private String imagen;
    private String nombre;

    public ProductoDetalleDTO(String imagen, String nombre) {
        this.imagen = imagen;
        this.nombre = nombre;
    }
}
