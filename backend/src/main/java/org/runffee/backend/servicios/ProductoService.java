package org.runffee.backend.servicios;

import org.runffee.backend.DTO.ProductoCrearDTO;
import org.runffee.backend.DTO.ProductoDetalleCrearDTO;
import org.runffee.backend.modelos.Cafeteria;
import org.runffee.backend.modelos.Producto;
import org.runffee.backend.modelos.Usuario;
import org.runffee.backend.repositorios.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    @Autowired
    private IProductoRepository productoRepository;

    public List<Producto> obtenerProductos() {
        return productoRepository.findAll()
                .stream()
                .filter(producto -> !producto.getEliminado())
                .toList();
    }

    public Producto obtenerProducto(int id) {
        return productoRepository.findById(id).orElse(null);
    }

    public List<ProductoDetalleCrearDTO> obtenerProductoDetalles() {
        return productoRepository.findAll().stream()
                .map(producto -> new ProductoDetalleCrearDTO(producto.getImagen(), producto.getNombre()))
                .collect(Collectors.toList());
    }

    public void crearProducto(ProductoCrearDTO producto) {
        Producto nuevoProducto = new Producto();

        nuevoProducto.setNombre(producto.getNombre());
        nuevoProducto.setImagen(producto.getImagen());
        nuevoProducto.setPrecio(producto.getPrecio());
        nuevoProducto.setDescripcion(producto.getDescripcion());

        productoRepository.save(nuevoProducto);
    }

    public void eliminarProducto(int id) {
        Producto producto = productoRepository.findById(id).orElse(null);
        if (producto != null) {
            producto.setEliminado(true);
        }
    }
}
