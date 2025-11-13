package org.runffee.backend.servicios;

import org.runffee.backend.DTO.ValoracionDTO;
import org.runffee.backend.modelos.Cafeteria;
import org.runffee.backend.modelos.LineaPedido;
import org.runffee.backend.modelos.Pedido;
import org.runffee.backend.modelos.Valoracion;
import org.runffee.backend.repositorios.ILineaPedidoRepository;
import org.runffee.backend.repositorios.IPedidoRepository;
import org.runffee.backend.repositorios.IProductoRepository;
import org.runffee.backend.repositorios.IValoracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class ValoracionService {

    @Autowired
    private IValoracionRepository valoracionRepository;

    /**
     * Función que devuelve todas las valoraciones
     * @return
     */
    public List<Valoracion> obtenerValoraciones() {
        return valoracionRepository.findAll()
                .stream()
                .filter(valoracion -> !valoracion.getEliminado())
                .toList();
    }

    /**
     * Función que devuelve la valoración por su id
     * @param id
     * @return
     */
    public Valoracion obtenerValoracion(int id) {
        return valoracionRepository.findById(id).orElse(null);
    }

    /**
     * Función para crear una valoración
     * @param valoracion
     */
    public void crearValoracion(ValoracionDTO valoracion) {
        Valoracion nuevaValoracion = new Valoracion();

        nuevaValoracion.setTitulo(valoracion.getTitulo());
        nuevaValoracion.setCantidad(valoracion.getCantidad());
        nuevaValoracion.setDescripcion(valoracion.getDescripcion());

        valoracionRepository.save(nuevaValoracion);
    }

    /**
     * Función para elimminar una valoración por su id
     * @param id
     */
    public void eliminarValoracion(int id) {
        Valoracion valoracion = valoracionRepository.findById(id).orElse(null);
        if (valoracion != null) {
            valoracion.setEliminado(true);
        }
    }

    /*
        Funcion para obtener media de valoraciones por cafeteria,
        vamos obteniendo datos de la cafeteria seleccionada uno a uno con flatMap
        hasta valoraciones donde optenemos todas estas para calcular la media
     */
    private IProductoRepository productoRepository;
    private ILineaPedidoRepository lineaPedidoRepository;
    private IPedidoRepository pedidoRepository;

    public BigDecimal obtenerMediaValoracionCafeteria(Cafeteria cafeteria) {
        List<Valoracion> valoraciones = productoRepository.findByCafeteria(cafeteria).stream()
                .flatMap(producto -> lineaPedidoRepository.findByProducto(producto).stream())
                .map(LineaPedido::getPedido)
                .map(Pedido::getValoracion)
                .toList();

        BigDecimal suma = BigDecimal.ZERO;
        int contador = 0;

        for (Valoracion valoracion : valoraciones) {
            suma = suma.add(valoracion.getCantidad());
            contador++;
        }

        return suma.divide(BigDecimal.valueOf(contador), 2, RoundingMode.HALF_UP);
    }
}
