package org.runffee.backend.servicios;

import org.runffee.backend.modelos.Pedido;
import org.runffee.backend.repositorios.IPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private IPedidoRepository pedidoRepository;

    public List<Pedido> obtenerPedidos() {
        return pedidoRepository.findAll();
    }

}
