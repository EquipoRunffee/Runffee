package org.runffee.backend.DTO;

import lombok.Data;

@Data
public class UsuarioCrearDTO {
    private String nombre;
    private String correo;
    private String contrasena;
    private String ciudad;
    private String pais;
    private Integer sexo;
    private String imagen;
    private Boolean eliminado;
}
