package org.runffee.backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrearPedidoDTO {
    private Integer idCafeteria;
    private Integer idReto;
    private String nombreCupon;
    private Integer tiempo_objetivo;
    private Double km_objetivo;
    private List<ProductoCarritoDTO> productosCarrito;
}
