package org.runffee.backend.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValoracionCafeteriaDTO {
    private String titulo;
    private BigDecimal cantidad;
    private String descripcion;
}

