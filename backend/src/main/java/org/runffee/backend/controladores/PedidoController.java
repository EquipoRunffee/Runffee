package org.runffee.backend.controladores;

import org.runffee.backend.DTO.PedidoCrearDTO;
import org.runffee.backend.DTO.RetoCrearDTO;
import org.runffee.backend.modelos.Pedido;
import org.runffee.backend.modelos.Reto;
import org.runffee.backend.servicios.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Pedido obtenerPedido(@PathVariable int id){
        return pedidoService.obtenerPedido(id);
    }

    @PostMapping("/crear")
    public void crearPedido(@RequestBody PedidoCrearDTO pedido){
        pedidoService.crearPedido(pedido);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarPedido(@PathVariable Integer id){
        pedidoService.eliminarPedido(id);
    }
}
