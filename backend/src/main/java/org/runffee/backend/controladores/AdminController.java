package org.runffee.backend.controladores;

import org.runffee.backend.DTO.AdminCrearModificarCafeteriaDTO;
import org.runffee.backend.DTO.AdminCrearModificarEntrenamientoDTO;
import org.runffee.backend.DTO.AdminCrearModificarProductoDTO;
import org.runffee.backend.DTO.AdminCrearModificarRetoDTO;

import org.runffee.backend.modelos.Producto;

import org.runffee.backend.servicios.AdminCrearModificarCafeteriaService;
import org.runffee.backend.servicios.AdminCrearModificarEntrenamientoService;
import org.runffee.backend.servicios.AdminCrearModificarProductoService;
import org.runffee.backend.servicios.AdminCrearModificarRetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://www.anderolivos.com"
})
public class AdminController {

    @Autowired
    private AdminCrearModificarProductoService adminProductoService;

    @Autowired
    private AdminCrearModificarCafeteriaService adminCafeteriaService;

    @Autowired
    private AdminCrearModificarRetoService adminRetoService;

    @Autowired
    private AdminCrearModificarEntrenamientoService adminEntrenamientoService;

    /***
     * API para crear un nuevo producto
     * @param producto
     */
    @PostMapping("/producto/crear")
    public void crearProducto(@RequestBody AdminCrearModificarProductoDTO producto){
        adminProductoService.crearProducto(producto);
    }

    /**
     * API que devuelve el producto por su id
     * @param id
     * @return
     */
    @GetMapping("/producto/obtener/{id}")
    public AdminCrearModificarProductoDTO obtenerProducto(@PathVariable int id){
        return adminProductoService.obtenerProductoDTO(id);
    }

    /***
     * API para modificar un producto
     * @param id
     * @param dto
     */
    @PutMapping("/producto/modificar/{id}")
    public void modificarProducto(@PathVariable int id, @RequestBody AdminCrearModificarProductoDTO dto) {
        adminProductoService.modificarProducto(id, dto);
    }

    /***
     * API para eliminar un producto por su id
     * @param id
     */
    @DeleteMapping("/producto/eliminar/{id}")
    public void eliminarProducto(@PathVariable Integer id){
        adminProductoService.eliminarProducto(id);
    }


    /***
     * API que devuelve la cafeteria por su id
     * @param id
     */

    @GetMapping("/cafeteria/obtener/{id}")
    public AdminCrearModificarCafeteriaDTO obtenerCafeteria(@PathVariable int id){
        return adminCafeteriaService.obtenerCafeteria(id);
    }

    /***
     * API para crear una nueva cafeteria
     * @param cafeteria
     */
    @PostMapping("/cafeteria/crear")
    public void crearCafeteria(@RequestBody AdminCrearModificarCafeteriaDTO cafeteria){
        adminCafeteriaService.crearCafeteria(cafeteria);
    }

    /***
     * API para modificar una cafeteria
     * @param id
     * @param dto
     */
    @PutMapping("/cafeteria/modificar/{id}")
    public void modificarCafeteria(@PathVariable int id, @RequestBody AdminCrearModificarCafeteriaDTO dto) {
        adminCafeteriaService.modificarCafeteria(id, dto);
    }

    /***
     * API para eliminar una cafeteria por su id
     * @param id
     */

    @DeleteMapping("/cafeteria/eliminar/{id}")
    public void eliminarCafeteria(@PathVariable Integer id){
        adminCafeteriaService.eliminarCafeteria(id);
    }


    /***
     * API que devuelve el reto por su id
     * @param id
     */

    @GetMapping("/reto/obtener/{id}")
    public AdminCrearModificarRetoDTO obtenerReto(@PathVariable int id){
        return adminRetoService.obtenerReto(id);
    }



    /***
     * API para crear un nuevo reto
     * @param reto
     */
    @PostMapping("/reto/crear")
    public void crearReto(@RequestBody AdminCrearModificarRetoDTO reto){
        adminRetoService.crearReto(reto);
    }

    /***
     * API para modificar un reto
     * @param id
     * @param dto
     */
    @PutMapping("/reto/modificar/{id}")
    public void modificarReto(@PathVariable int id, @RequestBody AdminCrearModificarRetoDTO dto){
        adminRetoService.modificarReto(id, dto);
    }

    /***
     * API para eliminar un reto por su id
     * @param id
     */
    @DeleteMapping("/reto/eliminar/{id}")
    public void eliminarReto(@PathVariable Integer id){
        adminRetoService.eliminarReto(id);
    }


    /***
     * API que devuelve un entrenamiento por id
     * @param id
     */
    @GetMapping("/entrenamiento/obtener/{id}")
    public AdminCrearModificarEntrenamientoDTO obtenerEntrenamiento(@PathVariable int id){
        return adminEntrenamientoService.obtenerEntrenamiento(id);
    }

    /***
     * API para modificar un entrenamiento
     * @param id
     * @param dto
     */
    @PutMapping("/entrenamiento/modificar/{id}")
    public void modificarEntrenamiento(@PathVariable int id, @RequestBody AdminCrearModificarEntrenamientoDTO dto){
        adminEntrenamientoService.modificarEntrenamiento(id, dto);
    }

}