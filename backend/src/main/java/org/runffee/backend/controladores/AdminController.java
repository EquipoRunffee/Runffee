package org.runffee.backend.controladores;

import org.runffee.backend.DTO.AdminCrearModificarProductoDTO;
import org.runffee.backend.DTO.AdminModificarUsuarioDTO;
import org.runffee.backend.modelos.Producto;
import org.runffee.backend.modelos.Usuario;
import org.runffee.backend.servicios.*;
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
    private AdminModificarUsuarioService adminModificarUsuarioService;

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

    /**
     * API que devuelve el usuario por su id
     * @param id
     * @return
     */
    @GetMapping("/usuario/obtener/{id}")
    public AdminModificarUsuarioDTO obtenerUsuarioPorId(@PathVariable int id) {
        return adminModificarUsuarioService.obtenerUsuario(id);
    }

    /**
     * API para modificar un usuario por su id
     * @param id
     * @param dto
     */
    @PutMapping("/usuario/modificar/{id}")
    public void modificarUsuario(@PathVariable int id, @RequestBody AdminModificarUsuarioDTO dto) {
        adminModificarUsuarioService.modificarUsuario(id, dto);
    }

    /**
     * API para eliminar un usuario por su id
     * @param id
     */
    @DeleteMapping("/usuario/eliminar/{id}")
    public void eliminarUsuario(@PathVariable Integer id){
        adminModificarUsuarioService.eliminarUsuario(id);
    }
}

