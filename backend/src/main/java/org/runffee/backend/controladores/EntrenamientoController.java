package org.runffee.backend.controladores;

import org.runffee.backend.DTO.EntrenamientoCrearDTO;
import org.runffee.backend.DTO.EntrenamientoDetalleCrearDTO;
import org.runffee.backend.DTO.ProductoCrearDTO;
import org.runffee.backend.DTO.ProductoDetalleCrearDTO;
import org.runffee.backend.modelos.Entrenamiento;
import org.runffee.backend.modelos.Producto;
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

    @GetMapping
    public List<Entrenamiento> obtenerEntrenamientos() {
        return entrenamientoService.obtenerEntrenamientos();
    }

    @GetMapping("/{id}")
    public Entrenamiento obtenerEntrenamiento(@PathVariable int id){
        return entrenamientoService.obtenerEntrenamiento(id);
    }

    @GetMapping("/detalles")
    public List<EntrenamientoDetalleCrearDTO> obtenerEntrenamientoDetalles() {
        return entrenamientoService.obtenerEntrenamientoDetalles();
    }

    @PostMapping("/crear")
    public void crearEntrenamiento(@RequestBody EntrenamientoCrearDTO entrenamiento){
        entrenamientoService.crearEntrenamiento(entrenamiento);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarEntrenamiento(@PathVariable Integer id){
        entrenamientoService.eliminarEntrenamiento(id);
    }
}
