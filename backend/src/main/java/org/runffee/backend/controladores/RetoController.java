package org.runffee.backend.controladores;

import org.runffee.backend.DTO.RetoDTO;
import org.runffee.backend.modelos.Reto;
import org.runffee.backend.modelos.Usuario;
import org.runffee.backend.repositorios.IUsuarioRepository;
import org.runffee.backend.servicios.AuthService;
import org.runffee.backend.servicios.JwtService;
import org.runffee.backend.servicios.RetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reto")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://www.anderolivos.com",
        "https://anderolivos.com"
})
public class RetoController {

    @Autowired
    private RetoService retoService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    /***
     * API que devuelve una lista con todos los retos
     * @return
     */
    @GetMapping
    public ResponseEntity<?> obtenerRetos(@RequestHeader(value = "Authorization", required = false) String authHeader) {
        if(authHeader != null && authHeader.startsWith("Bearer ")){
            String token = authHeader.substring(7);
            Integer idUsuario = jwtService.obtenerIdUsuario(token);
            Usuario usuario = usuarioRepository.findById(idUsuario).get();

            if(!jwtService.validarToken(token)){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of("error", "Token expirado"));
            }

            return retoService.obtenerRetosDisponiblesUsuario(usuario);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "No hay token"));
    }

    /***
     * API que devuelve el reto por su id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Reto obtenerReto(@PathVariable int id){
        return retoService.obtenerReto(id);
    }

    /***
     * API para crear un nuevo reto
     * @param reto
     */
    @PostMapping("/crear")
    public void crearReto(@RequestBody RetoDTO reto){
        retoService.crearReto(reto);
    }

    /**
     * API para eliminar un reto por su id
     * @param id
     */
    @DeleteMapping("/eliminar/{id}")
    public void eliminarReto(@PathVariable Integer id){
        retoService.eliminarReto(id);
    }
}
