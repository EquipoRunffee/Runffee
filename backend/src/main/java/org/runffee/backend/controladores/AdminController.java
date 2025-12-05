package org.runffee.backend.controladores;

import org.runffee.backend.DTO.AdminCrearModificarCafeteriaDTO;
import org.runffee.backend.DTO.AdminCrearModificarProductoDTO;
import org.runffee.backend.DTO.AdminCrearModificarRetoDTO;

import org.runffee.backend.modelos.Producto;

import org.runffee.backend.servicios.AdminCrearModificarCafeteriaService;
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
    private AdminCrearModificarCafeteriaService adminCafeteriaService;
    private AdminCrearModificarRetoService adminRetoService;

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

    @GetMapping("/cafeteria/modificar/{id}")
    public AdminCrearModificarCafeteriaDTO obtenerCafeteria(@PathVariable int id){
        return adminCafeteriaService.obtenerCafeteria(id);
    }

    /***
     * API para crear un nuevo producto
     * @param cafeteria
     */
    @PostMapping("/producto/crear")
    public void crearCafeteria(@RequestBody AdminCrearModificarCafeteriaDTO cafeteria){
        adminCafeteriaService.crearCafeteria(cafeteria);
    }


    /***
     * API que devuelve el reto por su id
     * @param id
     */

    @GetMapping("/reto/modificar/{id}")
    public AdminCrearModificarRetoDTO obtenerReto(@PathVariable int id){
        return adminRetoService.obtenerReto(id);
    }

}