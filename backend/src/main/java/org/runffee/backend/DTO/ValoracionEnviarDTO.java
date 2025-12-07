package org.runffee.backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValoracionEnviarDTO {
    private Integer idPedido;
    private String titulo;
    private String descripcion;
    private Double cantidad;
}
