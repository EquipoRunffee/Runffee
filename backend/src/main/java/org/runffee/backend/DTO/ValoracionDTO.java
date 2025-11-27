package org.runffee.backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
<<<<<<< HEAD
import lombok.NoArgsConstructor;
=======
import org.runffee.backend.modelos.Valoracion;
>>>>>>> main

import java.math.BigDecimal;

/**
 * DTO con todos los datos de la valoracion
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValoracionDTO {
    private String titulo;
    private BigDecimal cantidad;
    private String descripcion;
    private Boolean eliminado;
    private String nombreCafeteria;

<<<<<<< HEAD
=======
    public ValoracionDTO(String titulo, BigDecimal cantidad, String descripcion, Boolean eliminado, String nombreCafeteria) {
        this.titulo = titulo;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.eliminado = eliminado;
        this.nombreCafeteria = nombreCafeteria;
    }
>>>>>>> main
}
