package org.runffee.backend.controladores;

import org.runffee.backend.modelos.Valoracion;
import org.runffee.backend.servicios.ValoracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
