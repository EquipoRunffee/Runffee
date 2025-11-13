package org.runffee.backend.controladores;

import org.runffee.backend.DTO.CuponDTO;
import org.runffee.backend.modelos.Cupon;
import org.runffee.backend.servicios.CuponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /***
     * API que devuelve una lista de todos los cupones
     * @return
     */
    @GetMapping
    public List<Cupon> obtenerCupones() {
        return cuponService.obtenerCupones();
    }

    /***
     * API que devuelve el cupón buscado por id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Cupon obtenerCupon(@PathVariable int id){
        return cuponService.obtenerCupon(id);
    }

    /***
     * API para crear un cupón nuevo
     * @param cupon
     */
    @PostMapping("/crear")
    public void crearCupon(@RequestBody CuponDTO cupon){
        cuponService.crearCupon(cupon);
    }

    /***
     * API para eliminar un cupón por su id
     * @param id
     */
    @DeleteMapping("/eliminar/{id}")
    public void eliminarCupon(@PathVariable Integer id){
        cuponService.eliminarCupon(id);
    }
}
