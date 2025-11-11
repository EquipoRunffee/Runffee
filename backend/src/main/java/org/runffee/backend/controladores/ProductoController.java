package org.runffee.backend.controladores;

import org.runffee.backend.DTO.ProductoCrearDTO;
import org.runffee.backend.DTO.ProductoDetalleCrearDTO;
import org.runffee.backend.DTO.ValoracionCrearDTO;
import org.runffee.backend.modelos.Producto;
import org.runffee.backend.modelos.Valoracion;
import org.runffee.backend.servicios.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://www.anderolivos.com"
})
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> obtenerProductos() {
        return productoService.obtenerProductos();
    }

    @GetMapping("/{id}")
    public Producto obtenerProducto(@PathVariable int id){
        return productoService.obtenerProducto(id);
    }

    @GetMapping("/detalles")
    public List<ProductoDetalleCrearDTO> obtenerProductoDetalles() {
        return productoService.obtenerProductoDetalles();
    }

    @PostMapping("/crear")
    public void crearProducto(@RequestBody ProductoCrearDTO producto){
        productoService.crearProducto(producto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarProducto(@PathVariable Integer id){
        productoService.eliminarProducto(id);
    }
}
