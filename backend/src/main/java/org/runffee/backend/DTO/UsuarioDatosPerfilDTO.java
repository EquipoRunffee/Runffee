package org.runffee.backend.DTO;

import lombok.Data;

@Data
public class UsuarioDatosPerfilDTO {
    String nombre, apellidos, correo, ciudad, pais, sexo, imagen;
    private Integer totalEntrenamientos;
}
