package org.runffee.backend.controladores;

import org.runffee.backend.modelos.Entrenamiento;
import org.runffee.backend.servicios.EntrenamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entrenamiento")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://anderolivos.com"
})
public class EntrenamientoController {

    @Autowired
    private EntrenamientoService entrenamientoService;

    @GetMapping
    public List<Entrenamiento> obtenerEntrenamientos() {
        return entrenamientoService.obtenerEntrenamientos();
    }
}
