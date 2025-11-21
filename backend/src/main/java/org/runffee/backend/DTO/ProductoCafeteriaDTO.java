package org.runffee.backend.DTO;

import org.runffee.backend.modelos.Producto;
import org.runffee.backend.modelos.Valoracion;

import java.util.ArrayList;
import java.util.List;

public class ProductoCafeteriaDTO {
    private Integer id_producto;
    private String nombre_producto;
    private String imagen_producto;
    private Integer vendido;

    public ProductoCafeteriaDTO(Integer id_producto, String nombre_producto, String imagen_producto, Integer vendido) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.imagen_producto = imagen_producto;
        this.vendido = vendido;
    }
}
