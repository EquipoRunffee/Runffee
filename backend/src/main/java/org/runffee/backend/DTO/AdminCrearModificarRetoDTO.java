package org.runffee.backend.DTO;

import org.runffee.backend.modelos.Entrenamiento;

import java.util.Date;

public class AdminCrearModificarRetoDTO {
    private String nombre;
    private Date fecha_inicio;
    private Date fecha_caducidad;
    private String descripcion;
    private Boolean eliminado;
}
