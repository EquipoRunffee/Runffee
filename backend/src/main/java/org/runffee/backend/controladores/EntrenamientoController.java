package org.runffee.backend.controladores;

import org.runffee.backend.DTO.EntrenamientoDTO;
import org.runffee.backend.DTO.EntrenamientoDetalleDTO;
import org.runffee.backend.modelos.Entrenamiento;
import org.runffee.backend.servicios.EntrenamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
