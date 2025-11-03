package org.runffee.backend.servicios;

import org.runffee.backend.modelos.Producto;
import org.runffee.backend.repositorios.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private IProductoRepository productoRepository;

    public List<Producto> obtenerProductos() {
        return productoRepository.findAll();
    }

}
