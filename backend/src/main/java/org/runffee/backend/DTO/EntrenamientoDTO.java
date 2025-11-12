package org.runffee.backend.DTO;

import lombok.Data;
import org.runffee.backend.modelos.Pedido;
import org.runffee.backend.modelos.Usuario;

import java.math.BigDecimal;
import java.util.Date;

/**
 * DTO con todos los datos del entrenamiento
 */
@Data
public class EntrenamientoDTO {
    private String nombre;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String url_mapa;
    private String descripcion;
    private BigDecimal distancia;
    private Boolean eliminado;
    private Usuario usuario;
    private Pedido pedido;
}
