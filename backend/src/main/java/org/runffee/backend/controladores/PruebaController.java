package org.runffee.backend.controladores;

import org.runffee.backend.modelos.Prueba;
import org.runffee.backend.servicios.PruebaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prueba")
public class PruebaController {

    @Autowired
    private PruebaService pruebaService;

    @GetMapping
    public List<Prueba> prueba() {
        return pruebaService.obtenerPruebas();
    }
}
