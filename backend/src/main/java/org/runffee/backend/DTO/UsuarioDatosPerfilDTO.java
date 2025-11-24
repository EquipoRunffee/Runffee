package org.runffee.backend.DTO;

import lombok.Data;
import org.runffee.backend.modelos.UsuarioSexo;

@Data
public class UsuarioDatosPerfilDTO {
    String nombre, apellidos, correo, ciudad, pais;
    UsuarioSexo sexo;
    private Integer totalEntrenamientos;
}
