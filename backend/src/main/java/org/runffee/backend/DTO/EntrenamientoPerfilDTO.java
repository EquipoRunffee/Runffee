package org.runffee.backend.DTO;

import lombok.Data;
import org.runffee.backend.modelos.Cafeteria;
import org.runffee.backend.modelos.Cupon;
import org.runffee.backend.modelos.LineaPedido;
import org.runffee.backend.modelos.Pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class EntrenamientoPerfilDTO {
    private String nombre;
    private String descripcion;
    private Boolean completado;
    private Double stravaKm;
    private Integer stravaTiempo;
    private String urlMapa;
    private Pedido pedido;
    private Cupon cuponAplicado;
    private List<LineaPedido> lineasPedido;
    private LocalDateTime fechaPedido;
    private Double kmObjetivo;
    private Integer tiempoObjetivo;

    public EntrenamientoPerfilDTO(String nombre, String descripcion, Boolean completado, Double stravaKm, Integer stravaTiempo, String urlMapa) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.completado = completado;
        this.stravaKm = stravaKm;
        this.stravaTiempo = stravaTiempo;
        this.urlMapa = urlMapa;
    }
}
