package org.runffee.backend.servicios;

import org.runffee.backend.DTO.LineaPedidoDTO;
import org.runffee.backend.modelos.LineaPedido;
import org.runffee.backend.repositorios.ILineaPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineaPedidoService {

    @Autowired
    private ILineaPedidoRepository lineaPedidoRepository;

    /**
     * Función que devuelve todas las lineas de pedido
     * @return
     */
    public List<LineaPedido> obtenerLineasPedidos() {
        return lineaPedidoRepository.findAll()
                .stream()
                .filter(lineaPedido -> !lineaPedido.getEliminado())
                .toList();
    }

    /**
     * Función que devuelve la linea de pedido por id
     * @param id
     * @return
     */
    public LineaPedido obtenerLineaPedido(int id) {
        return lineaPedidoRepository.findById(id).orElse(null);
    }

    /**
     * Función para crear una linea de pedido
     * @param lineaPedido
     */
    public void crearLineaPedido(LineaPedidoDTO lineaPedido) {
        LineaPedido nuevaLineaCliente = new LineaPedido();

        nuevaLineaCliente.setCantidadProducto(lineaPedido.getCantidadProducto());

        lineaPedidoRepository.save(nuevaLineaCliente);
    }

    /**
     * Función para eliminar una linea de pedido
     * @param id
     */

    public void eliminarLineasPedido(int id) {
        LineaPedido lineaPedido = lineaPedidoRepository.findById(id).orElse(null);
        if (lineaPedido != null) {
            lineaPedido.setEliminado(true);
        }
    }

}
