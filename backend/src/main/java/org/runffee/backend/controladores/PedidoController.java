package org.runffee.backend.controladores;

import org.runffee.backend.DTO.CrearPedidoDTO;
import org.runffee.backend.DTO.PedidoDTO;
import org.runffee.backend.modelos.Pedido;
import org.runffee.backend.modelos.Usuario;
import org.runffee.backend.repositorios.IUsuarioRepository;
import org.runffee.backend.servicios.JwtService;
import org.runffee.backend.servicios.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pedido")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://www.anderolivos.com",
        "https://anderolivos.com"
})
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private IUsuarioRepository usuarioRepository;

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

    @PostMapping("/crearpedido")
    public ResponseEntity<?> crearPedidoCarrito(@RequestBody CrearPedidoDTO carrito, @RequestHeader(value = "Authorization", required = false) String authHeader){
        if(authHeader != null && authHeader.startsWith("Bearer ")){
            String token = authHeader.substring(7);
            Integer idUsuario = jwtService.obtenerIdUsuario(token);
            Usuario usuario = usuarioRepository.findById(idUsuario).get();

            if(!jwtService.validarToken(token)){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of("error", "Token expirado"));
            }

            return pedidoService.crearPedidoCarrito(carrito, usuario);
        }

        return null;
    }

}
