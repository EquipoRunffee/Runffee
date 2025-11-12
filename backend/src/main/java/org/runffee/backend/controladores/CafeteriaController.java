package org.runffee.backend.controladores;

import org.runffee.backend.DTO.CafeteriaCrearDTO;
import org.runffee.backend.DTO.CafeteriaDetalleCrearDTO;
import org.runffee.backend.modelos.Cafeteria;
import org.runffee.backend.servicios.CafeteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /***
     * API que devuelve todas las cafeterías (activas)
     * @return
     */
    @GetMapping
    public List<Cafeteria> obtenerCafeterias() {
        return cafeteriaService.obtenerCafeterias();
    }

    /***
     * API que devuelve la cafetería encontrada por id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Cafeteria obtenerCafeteria(@PathVariable int id){
        return cafeteriaService.obtenerCafeteria(id);
    }

    /***
     * API que devuelve
     * @return
     */
    @GetMapping("/detalles")
    public List<CafeteriaDetalleCrearDTO> obtenerCafeteriaDetalles() {
        return cafeteriaService.obtenerCafeteriaDetalles();
    }

    @PostMapping("/crear")
    public void crearCafeteria(@RequestBody CafeteriaCrearDTO cafeteria){
        cafeteriaService.crearCafeteria(cafeteria);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarCafeteria(@PathVariable Integer id){
        cafeteriaService.eliminarCafeteria(id);
    }

}
