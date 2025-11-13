package org.runffee.backend.controladores;

import org.runffee.backend.DTO.LineaPedidoDTO;
import org.runffee.backend.modelos.LineaPedido;
import org.runffee.backend.servicios.LineaPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /***
     * API para mostrar todas las lineas de pedido
     * @return
     */
    @GetMapping
    public List<LineaPedido> obtenerLineasPedidos() {
        return lineaPedidoService.obtenerLineasPedidos();
    }

    /***
     * API para mostrar la linea pedido por su id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public LineaPedido obtenerLineaPedido(@PathVariable int id){
        return lineaPedidoService.obtenerLineaPedido(id);
    }

    /***
     * API para crear una nueva linea de pedido
     * @param cliente
     */
    @PostMapping("/crear")
    public void crearLineaPedido(@RequestBody LineaPedidoDTO cliente){
        lineaPedidoService.crearLineaPedido(cliente);
    }

    /***
     * API para eliminar una linea de pedido por su id
     * @param id
     */
    @DeleteMapping("/eliminar/{id}")
    public void eliminarLineaPedido(@PathVariable Integer id){
        lineaPedidoService.eliminarLineasPedido(id);
    }
}
