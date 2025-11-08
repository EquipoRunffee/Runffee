package org.runffee.backend.controladores;

import org.runffee.backend.modelos.Reto;
import org.runffee.backend.servicios.RetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reto")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://www.anderolivos.com"
})
public class RetoController {

    @Autowired
    private RetoService retoService;

    @GetMapping
    public List<Reto> obtenerRetos() {
        return retoService.obtenerRetos();
    }
}
