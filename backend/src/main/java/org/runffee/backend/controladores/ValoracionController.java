package org.runffee.backend.controladores;

import org.runffee.backend.DTO.ValoracionDTO;
import org.runffee.backend.modelos.Usuario;
import org.runffee.backend.modelos.Valoracion;
import org.runffee.backend.repositorios.IUsuarioRepository;
import org.runffee.backend.servicios.JwtService;
import org.runffee.backend.servicios.StravaService;
import org.runffee.backend.servicios.ValoracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/valoracion")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://www.anderolivos.com"
})
public class ValoracionController {

    @Autowired
    private ValoracionService valoracionService;

    /**
     * API que devuelve una lista con todas las valoraciones
     * @return
     */
    @GetMapping
    public List<Valoracion> obtenerValoraciones() {
        return valoracionService.obtenerValoraciones();
    }

    /**
     * API que devuelve la valoracion por su id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Valoracion obtenerValoracion(@PathVariable int id){
        return valoracionService.obtenerValoracion(id);
    }

    /**
     * API que devuelve la valoracion filtrando por usuario
     * @param id
     * @return
     */
    @Autowired
    private JwtService jwtService;

    @GetMapping("/valoracionesUsuario")
    public Object obtenerValoracionesUsuario(@RequestHeader(value = "Authorization", required = false) String authHeader){

        if(authHeader != null && authHeader.startsWith("Bearer ")){
            String token = authHeader.substring(7);
            Integer idUsuario = jwtService.obtenerIdUsuario(token);

            if(!jwtService.validarToken(token)){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of("error", "Token expirado"));
            }
            return valoracionService.obtenerValoracionEntrenamiento(idUsuario);
        }
        return null;
    }

    /**
     * API para crear una valoracion nueva
     * @param cliente
     */
    @PostMapping("/crear")
    public void crearValoracion(@RequestBody ValoracionDTO cliente){
        valoracionService.crearValoracion(cliente);
    }

    /**
     * API para eliminar una valoracion por su id
     * @param id
     */
    @DeleteMapping("/eliminar/{id}")
    public void eliminarValoracion(@PathVariable Integer id){
        valoracionService.eliminarValoracion(id);
    }
}
