package org.runffee.backend.controladores;

import org.runffee.backend.modelos.Pedido;
import org.runffee.backend.servicios.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://anderolivos.com"
})
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> obtenerPedidos() {
        return pedidoService.obtenerPedidos();
    }
}
