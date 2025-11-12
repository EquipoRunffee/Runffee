package org.runffee.backend.DTO;

import lombok.Data;
import org.runffee.backend.modelos.Entrenamiento;

import java.util.Date;

@Data
public class RetoCrearDTO {
    private String nombre;
    private Date fecha_inicio;
    private Date fecha_caducidad;
    private String descripcion;
    private Boolean eliminado;
    private Entrenamiento entrenamiento;
}
