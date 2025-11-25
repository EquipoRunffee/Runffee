package org.runffee.backend.controladores;

import org.runffee.backend.DTO.CafeteriaDTO;
import org.runffee.backend.DTO.CafeteriaDetalleDTO;
import org.runffee.backend.DTO.CafeteriaProductosDTO;
import org.runffee.backend.DTO.ListaProductoDTO;
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
    public List<CafeteriaDetalleDTO> obtenerCafeteriaDetalles() {
        return cafeteriaService.obtenerCafeteriaDetalles();
    }

    /***
     * API para crear una cafeteria
     * @param cafeteria
     */
    @PostMapping("/crear")
    public void crearCafeteria(@RequestBody CafeteriaDTO cafeteria){
        cafeteriaService.crearCafeteria(cafeteria);
    }

    /***
     * API para eliminar una cafeteria
     * @param id
     */
    @DeleteMapping("/eliminar/{id}")
    public void eliminarCafeteria(@PathVariable Integer id){
        cafeteriaService.eliminarCafeteria(id);
    }

    @GetMapping("/{id}/productos")
    public CafeteriaProductosDTO obtenerCafeteriaProductos(@PathVariable int id){
        return cafeteriaService.obtenerListaProductosCafeteria(id);
    }
}
