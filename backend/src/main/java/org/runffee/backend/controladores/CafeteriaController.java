package org.runffee.backend.controladores;

import org.runffee.backend.modelos.Cafeteria;
import org.runffee.backend.servicios.CafeteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cafeteria")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://anderolivos.com"
})
public class CafeteriaController {

    @Autowired
    private CafeteriaService cafeteriaService;

    @GetMapping
    public List<Cafeteria> obtenerCafeterias() {
        return cafeteriaService.obtenerCafeterias();
    }
}
