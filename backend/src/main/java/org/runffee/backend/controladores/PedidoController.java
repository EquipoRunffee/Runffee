package org.runffee.backend.controladores;

import org.runffee.backend.DTO.PedidoDTO;
import org.runffee.backend.modelos.Pedido;
import org.runffee.backend.servicios.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://www.anderolivos.com"
})
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    /***
     * API que devuelve una lista de todos los pedidos
     * @return
     */
    @GetMapping
    public List<Pedido> obtenerPedidos() {
        return pedidoService.obtenerPedidos();
    }

    /***
     * API que devuelve el pedido por su id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Pedido obtenerPedido(@PathVariable int id){
        return pedidoService.obtenerPedido(id);
    }


    /***
     * API que crea un nuevo pedido
     * @param pedido
     */
    @PostMapping("/crear")
    public void crearPedido(@RequestBody PedidoDTO pedido){
        pedidoService.crearPedido(pedido);
    }

    /***
     * API para eliminar un pedido
     * @param id
     */
    @DeleteMapping("/eliminar/{id}")
    public void eliminarPedido(@PathVariable Integer id){
        pedidoService.eliminarPedido(id);
    }
}
