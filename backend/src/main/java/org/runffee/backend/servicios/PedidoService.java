package org.runffee.backend.servicios;

import org.runffee.backend.DTO.PedidoDTO;
import org.runffee.backend.modelos.Pedido;
import org.runffee.backend.repositorios.IPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private IPedidoRepository pedidoRepository;

    /**
     * Función que devuelve todos los pedidos
     * @return
     */
    public List<Pedido> obtenerPedidos() {
        return pedidoRepository.findAll()
                .stream()
                .filter(pedido -> !pedido.getEliminado())
                .toList();
    }

    /**
     * Función que devuelve el pedido por id
     * @param id
     * @return
     */
    public Pedido obtenerPedido(int id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    /**
     * Función para crear un nuevo pedido
     * @param pedido
     */
    public void crearPedido(PedidoDTO pedido) {
        Pedido nuevoPedido = new Pedido();

        nuevoPedido.setCuponAplicado(pedido.getCuponAplicado());
        nuevoPedido.setPrecioTotal(pedido.getPrecioTotal());
        nuevoPedido.setQr(pedido.getQr());
        nuevoPedido.setEstado(pedido.getEstado());

        pedidoRepository.save(nuevoPedido);
    }

    /**
     * Función para eliminar un pedido
     * @param id
     */
    public void eliminarPedido(int id) {
        Pedido pedido = pedidoRepository.findById(id).orElse(null);
        if (pedido != null) {
            pedido.setEliminado(true);
        }
    }

}
