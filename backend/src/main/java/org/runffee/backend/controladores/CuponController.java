package org.runffee.backend.controladores;

import org.runffee.backend.modelos.Cupon;
import org.runffee.backend.servicios.CuponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cupon")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://www.anderolivos.com"
})
public class CuponController {

    @Autowired
    private CuponService cuponService;

    @GetMapping
    public List<Cupon> obtenerCupones() {
        return cuponService.obtenerCupones();
    }
}
