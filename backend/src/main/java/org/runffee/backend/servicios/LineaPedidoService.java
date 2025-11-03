package org.runffee.backend.servicios;

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
        return lineaPedidoRepository.findAll();
    }

}
