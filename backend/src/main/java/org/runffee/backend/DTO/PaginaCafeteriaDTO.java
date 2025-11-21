package org.runffee.backend.DTO;

import org.runffee.backend.modelos.Producto;
import org.runffee.backend.modelos.Valoracion;

import java.util.ArrayList;
import java.util.List;

public class PaginaCafeteriaDTO {
    private String nombre;
    private String descripcion;
    private Double lat;
    private Double lng;
    private String imagen;
    private List<ProductoCafeteriaDTO> productos;
    private List<Valoracion> valoraciones;

    public PaginaCafeteriaDTO(String nombre, String descripcion, Double lat, Double lng, String imagen, List<ProductoCafeteriaDTO> productos, List<Valoracion> valoraciones) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.lat = lat;
        this.lng = lng;
        this.imagen = imagen;
        this.productos = productos;
        this.valoraciones = valoraciones;
    }

}
