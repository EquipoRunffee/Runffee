package org.runffee.backend.controladores;

import org.runffee.backend.DTO.LineaPedidoCrearDTO;
import org.runffee.backend.modelos.LineaPedido;
import org.runffee.backend.servicios.LineaPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lineapedido")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://anderolivos.com"
})
public class LineaPedidoController {

    @Autowired
    private LineaPedidoService lineaPedidoService;

    @GetMapping
    public List<LineaPedido> obtenerLineasPedidos() {
        return lineaPedidoService.obtenerLineasPedidos();
    }

    @GetMapping("/{id}")
    public LineaPedido obtenerLineaPedido(@PathVariable int id){
        return lineaPedidoService.obtenerLineaPedido(id);
    }

    @PostMapping("/crear")
    public void crearLineaPedido(@RequestBody LineaPedidoCrearDTO cliente){
        lineaPedidoService.crearLineaPedido(cliente);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarLineaPedido(@PathVariable Integer id){
        lineaPedidoService.eliminarLineasPedido(id);
    }
}
