package org.runffee.backend.DTO;

import lombok.Data;

@Data
public class CambiarContrasenaDTO {
    private String contrasenaVieja;
    private String contrasenaNueva;
}
