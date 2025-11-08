package org.runffee.backend.controladores;

import org.runffee.backend.modelos.Producto;
import org.runffee.backend.servicios.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
