package org.runffee.backend.DTO;

import lombok.Data;

@Data
public class UsuarioEncabezadoPerfilDTO {
    private String nombre;
    private String correo;
    private Integer totalEntrenamientos;
}
