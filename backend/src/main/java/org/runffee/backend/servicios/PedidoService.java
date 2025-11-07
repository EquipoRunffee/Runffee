package org.runffee.backend.servicios;

import org.runffee.backend.DTO.PedidoCrearDTO;
import org.runffee.backend.modelos.Cafeteria;
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
        return pedidoRepository.findAll()
                .stream()
                .filter(pedido -> !pedido.getEliminado())
                .toList();
    }

    public Pedido obtenerPedido(int id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public void crearPedido(PedidoCrearDTO pedido) {
        Pedido nuevoPedido = new Pedido();

        nuevoPedido.setCuponAplicado(pedido.getCuponAplicado());
        nuevoPedido.setPrecioTotal(pedido.getPrecioTotal());
        nuevoPedido.setQr(pedido.getQr());
        nuevoPedido.setEstado(pedido.getEstado());

        pedidoRepository.save(nuevoPedido);
    }

    public void eliminarPedido(int id) {
        Pedido pedido = pedidoRepository.findById(id).orElse(null);
        if (pedido != null) {
            pedido.setEliminado(true);
        }
    }

}
