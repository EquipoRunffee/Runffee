package org.runffee.backend.servicios;

import org.runffee.backend.DTO.ProductoDTO;
import org.runffee.backend.DTO.ProductoDetalleDTO;
import org.runffee.backend.modelos.Producto;
import org.runffee.backend.repositorios.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    @Autowired
    private IProductoRepository productoRepository;

    /**
     * Función que devuelve todos los productos
     * @return
     */
    public List<Producto> obtenerProductos() {
        return productoRepository.findAll()
                .stream()
                .filter(producto -> !producto.getEliminado())
                .toList();
    }

    /**
     * Función que devuelve el producto por id
     * @param id
     * @return
     */
    public Producto obtenerProducto(int id) {
        return productoRepository.findById(id).orElse(null);
    }

    /**
     * Función que devuelve todos los Productos Detalle
     * @return
     */
    public List<ProductoDetalleDTO> obtenerProductoDetalles() {
        return productoRepository.findAll().stream()
                .map(producto -> new ProductoDetalleDTO(producto.getImagen(), producto.getNombre()))
                .collect(Collectors.toList());
    }

    /**
     * Función para crear un producto
     * @param producto
     */
    public void crearProducto(ProductoDTO producto) {
        Producto nuevoProducto = new Producto();

        nuevoProducto.setNombre(producto.getNombre());
        nuevoProducto.setImagen(producto.getImagen());
        nuevoProducto.setPrecio(producto.getPrecio());
        nuevoProducto.setDescripcion(producto.getDescripcion());

        productoRepository.save(nuevoProducto);
    }


    /**
     * Función para eliminar un producto por id
     * @param id
     */
    public void eliminarProducto(int id) {
        Producto producto = productoRepository.findById(id).orElse(null);
        if (producto != null) {
            producto.setEliminado(true);
        }
    }
}
