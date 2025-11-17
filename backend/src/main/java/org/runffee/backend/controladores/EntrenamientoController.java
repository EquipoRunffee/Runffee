package org.runffee.backend.controladores;

import org.runffee.backend.DTO.EntrenamientoDTO;
import org.runffee.backend.DTO.EntrenamientoDetalleDTO;
import org.runffee.backend.modelos.Entrenamiento;
import org.runffee.backend.modelos.Usuario;
import org.runffee.backend.repositorios.IUsuarioRepository;
import org.runffee.backend.servicios.EntrenamientoService;
import org.runffee.backend.servicios.JwtService;
import org.runffee.backend.servicios.StravaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/entrenamiento")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://www.anderolivos.com"
})
public class EntrenamientoController {

    @Autowired
    private EntrenamientoService entrenamientoService;

    /***
     * API que devuelve una lista con todos los entrenamientos
     * @return
     */
    @GetMapping
    public List<Entrenamiento> obtenerEntrenamientos() {
        return entrenamientoService.obtenerEntrenamientos();
    }

    /***
     * API para obtener un entrenamiento por su id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Entrenamiento obtenerEntrenamiento(@PathVariable int id){
        return entrenamientoService.obtenerEntrenamiento(id);
    }

    /***
     * API que devuelve una lista con todos los Entrenamiento Detalle DTO
     * @return
     */
    @GetMapping("/detalles")
    public List<EntrenamientoDetalleDTO> obtenerEntrenamientoDetalles() {
        return entrenamientoService.obtenerEntrenamientoDetalles();
    }

    /***
     * API para crear un entrenamiento nuevo
     * @param entrenamiento
     */
    @PostMapping("/crear")
    public void crearEntrenamiento(@RequestBody EntrenamientoDTO entrenamiento){
        entrenamientoService.crearEntrenamiento(entrenamiento);
    }

    /***
     * API para eliminar un entrenamiento
     * @param id
     */
    @DeleteMapping("/eliminar/{id}")
    public void eliminarEntrenamiento(@PathVariable Integer id){
        entrenamientoService.eliminarEntrenamiento(id);
    }

    @Autowired
    private JwtService  jwtService;
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private StravaService stravaService;

    @GetMapping("/atleta")
    public Object obtenerEntrenamientosAtleta(@RequestHeader(value = "Authorization", required = false) String authHeader){

        if(authHeader != null && authHeader.startsWith("Bearer ")){
            String token = authHeader.substring(7);
            Integer idUsuario = jwtService.obtenerIdUsuario(token);
            Usuario usuario = usuarioRepository.findById(idUsuario).get();

            if(!jwtService.validarToken(token)){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of("error", "Token expirado"));
            }

            return stravaService.obtenerEntrenamientosAtleta(usuario.getStravaAccessToken());
        }

        return null;
    }
}
