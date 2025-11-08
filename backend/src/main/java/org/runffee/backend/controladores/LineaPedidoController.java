package org.runffee.backend.controladores;

import org.runffee.backend.modelos.LineaPedido;
import org.runffee.backend.servicios.LineaPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lineapedido")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://www.anderolivos.com"
})
public class LineaPedidoController {

    @Autowired
    private LineaPedidoService lineaPedidoService;

    @GetMapping
    public List<LineaPedido> obtenerLineasPedidos() {
        return lineaPedidoService.obtenerLineasPedidos();
    }
}
