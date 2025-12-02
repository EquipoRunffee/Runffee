package org.runffee.backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrearPedidoDTO {
    private Integer idCafeteria;
    private Integer idReto;
    private String nombreCupon;
    private Integer tiempoObjetivo;
    private Double kmObjetivo;
    private List<ProductoCarritoDTO> productosCarrito;
}
