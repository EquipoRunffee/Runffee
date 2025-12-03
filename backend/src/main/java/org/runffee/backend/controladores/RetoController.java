package org.runffee.backend.controladores;

import org.runffee.backend.DTO.RetoDTO;
import org.runffee.backend.modelos.Reto;
import org.runffee.backend.servicios.RetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /***
     * API que devuelve una lista con todos los retos
     * @return
     */
    @GetMapping
    public List<Reto> obtenerRetos() {
        return retoService.obtenerRetos();
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
