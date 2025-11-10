package org.runffee.backend.servicios;

import org.runffee.backend.DTO.LineaPedidoCrearDTO;
import org.runffee.backend.modelos.Cafeteria;
import org.runffee.backend.modelos.LineaPedido;
import org.runffee.backend.repositorios.ILineaPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineaPedidoService {

    @Autowired
    private ILineaPedidoRepository lineaPedidoRepository;

    public List<LineaPedido> obtenerLineasPedidos() {
        return lineaPedidoRepository.findAll()
                .stream()
                .filter(lineaPedido -> !lineaPedido.getEliminado())
                .toList();
    }

    public LineaPedido obtenerLineaPedido(int id) {
        return lineaPedidoRepository.findById(id).orElse(null);
    }

    public void crearLineaPedido(LineaPedidoCrearDTO lineaPedido) {
        LineaPedido nuevaLineaCliente = new LineaPedido();

        nuevaLineaCliente.setCantidadProducto(lineaPedido.getCantidadProducto());

        lineaPedidoRepository.save(nuevaLineaCliente);
    }

    public void eliminarLineasPedido(int id) {
        LineaPedido lineaPedido = lineaPedidoRepository.findById(id).orElse(null);
        if (lineaPedido != null) {
            lineaPedido.setEliminado(true);
        }
    }

}
