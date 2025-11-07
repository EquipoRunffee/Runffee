package org.runffee.backend.controladores;

import org.runffee.backend.DTO.ValoracionCrearDTO;
import org.runffee.backend.modelos.Valoracion;
import org.runffee.backend.servicios.ValoracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/valoracion")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://anderolivos.com"
})
public class ValoracionController {

    @Autowired
    private ValoracionService valoracionService;

    @GetMapping
    public List<Valoracion> obtenerValoraciones() {
        return valoracionService.obtenerValoraciones();
    }

    @GetMapping("/{id}")
    public Valoracion obtenerValoracion(@PathVariable int id){
        return valoracionService.obtenerValoracion(id);
    }

    @PostMapping("/crear")
    public void crearValoracion(@RequestBody ValoracionCrearDTO cliente){
        valoracionService.crearValoracion(cliente);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarValoracion(@PathVariable Integer id){
        valoracionService.eliminarValoracion(id);
    }
}
