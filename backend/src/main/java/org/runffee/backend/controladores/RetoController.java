package org.runffee.backend.controladores;

import org.runffee.backend.DTO.RetoCrearDTO;
import org.runffee.backend.DTO.ValoracionCrearDTO;
import org.runffee.backend.modelos.Reto;
import org.runffee.backend.modelos.Valoracion;
import org.runffee.backend.servicios.RetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reto")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://anderolivos.com"
})
public class RetoController {

    @Autowired
    private RetoService retoService;

    @GetMapping
    public List<Reto> obtenerRetos() {
        return retoService.obtenerRetos();
    }

    @GetMapping("/{id}")
    public Reto obtenerReto(@PathVariable int id){
        return retoService.obtenerReto(id);
    }

    @PostMapping("/crear")
    public void crearReto(@RequestBody RetoCrearDTO reto){
        retoService.crearReto(reto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarReto(@PathVariable Integer id){
        retoService.eliminarReto(id);
    }
}
