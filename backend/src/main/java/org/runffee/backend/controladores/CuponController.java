package org.runffee.backend.controladores;

import org.runffee.backend.DTO.CuponCrearDTO;
import org.runffee.backend.DTO.ValoracionCrearDTO;
import org.runffee.backend.modelos.Cupon;
import org.runffee.backend.modelos.Valoracion;
import org.runffee.backend.servicios.CuponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cupon")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://anderolivos.com"
})
public class CuponController {

    @Autowired
    private CuponService cuponService;

    @GetMapping
    public List<Cupon> obtenerCupones() {
        return cuponService.obtenerCupones();
    }

    @GetMapping("/{id}")
    public Cupon obtenerCupon(@PathVariable int id){
        return cuponService.obtenerCupon(id);
    }

    @PostMapping("/crear")
    public void crearCupon(@RequestBody CuponCrearDTO cupon){
        cuponService.crearCupon(cupon);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarCupon(@PathVariable Integer id){
        cuponService.eliminarCupon(id);
    }
}
