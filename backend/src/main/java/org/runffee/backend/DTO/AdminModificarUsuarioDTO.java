package org.runffee.backend.DTO;

import lombok.Data;
import org.runffee.backend.modelos.UsuarioRole;

/**
 * DTO con datos para poder modificar o eliminar un usuario
 */

@Data
public class AdminModificarUsuarioDTO {
    private String correo;
    private String contrasena;
    private UsuarioRole rol;
    private Boolean eliminado;
}
