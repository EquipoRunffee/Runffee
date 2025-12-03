package org.runffee.backend.controladores;

import org.runffee.backend.DTO.ProductoDTO;
import org.runffee.backend.DTO.ProductoDetalleDTO;
import org.runffee.backend.modelos.Producto;
import org.runffee.backend.servicios.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://www.anderolivos.com",
        "https://anderolivos.com"
})
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    /***
     * API para devuelve una lista de todos los productos
     * @return
     */
    @GetMapping
    public List<Producto> obtenerProductos() {
        return productoService.obtenerProductos();
    }

    /**
     * API que devuelve el producto por su id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Producto obtenerProducto(@PathVariable int id){
        return productoService.obtenerProducto(id);
    }


    /***
     * API que devuelve una lista de todos los Productos Detalle DTO
      * @return
     */
    @GetMapping("/detalles")
    public List<ProductoDetalleDTO> obtenerProductoDetalles() {
        return productoService.obtenerProductoDetalles();
    }

    /***
     * API para crear un nuevo producto
     * @param producto
     */
    @PostMapping("/crear")
    public void crearProducto(@RequestBody ProductoDTO producto){
        productoService.crearProducto(producto);
    }

    /***
     * API para eliminar un producto por su id
     * @param id
     */
    @DeleteMapping("/eliminar/{id}")
    public void eliminarProducto(@PathVariable Integer id){
        productoService.eliminarProducto(id);
    }
}
