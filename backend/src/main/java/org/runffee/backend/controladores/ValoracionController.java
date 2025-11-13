package org.runffee.backend.controladores;

import org.runffee.backend.DTO.ValoracionDTO;
import org.runffee.backend.modelos.Valoracion;
import org.runffee.backend.servicios.ValoracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
