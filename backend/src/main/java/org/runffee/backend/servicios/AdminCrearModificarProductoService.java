package org.runffee.backend.servicios;

import org.runffee.backend.DTO.AdminCrearModificarProductoDTO;
import org.runffee.backend.modelos.Cafeteria;
import org.runffee.backend.modelos.Producto;
import org.runffee.backend.repositorios.ICafeteriaRepository;
import org.runffee.backend.repositorios.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminCrearModificarProductoService {

    @Autowired
    private IProductoRepository productoRepository;

    @Autowired
    private ICafeteriaRepository cafeteriaRepository;

    /**
     * Función que devuelve el producto por id
     * @param id
     * @return
     */
    public Producto obtenerProducto(int id) {
        return productoRepository.findById(id).orElse(null);
    }

    /**
     * Función para crear un producto
     * @param producto
     */
    public void crearProducto(AdminCrearModificarProductoDTO producto) {
        Cafeteria cafeteria = cafeteriaRepository.findById(producto.getIdCafeteria()).orElse(null);
        if (cafeteria != null) {
            Producto nuevoProducto = new Producto();

            nuevoProducto.setNombre(producto.getNombre());
            nuevoProducto.setTipoProducto(producto.getTipoProducto());
            nuevoProducto.setImagen(producto.getImagen());
            nuevoProducto.setPrecio(producto.getPrecio());
            nuevoProducto.setDescripcion(producto.getDescripcion());
            nuevoProducto.setCafeteria(cafeteria);
            nuevoProducto.setEliminado(producto.getEliminado());

            productoRepository.save(nuevoProducto);
        }
    }

    /**
     * Función para modificar un producto
     * @param id
     * @param dto
     */
    public void modificarProducto(int id, AdminCrearModificarProductoDTO dto) {
        Cafeteria cafeteria = cafeteriaRepository.findById(dto.getIdCafeteria()).orElse(null);
        if (cafeteria != null) {
            Producto producto = productoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            producto.setNombre(dto.getNombre());
            producto.setTipoProducto(dto.getTipoProducto());
            producto.setImagen(dto.getImagen());
            producto.setPrecio(dto.getPrecio());
            producto.setDescripcion(dto.getDescripcion());
            producto.setEliminado(dto.getEliminado());
            producto.setCafeteria(cafeteria);

            productoRepository.save(producto);
        }
    }

    /**
     * Función para eliminar un producto por id
     * @param id
     */
    public void eliminarProducto(int id) {
        Producto producto = productoRepository.findById(id).orElse(null);
        if (producto != null) {
            producto.setEliminado(true);
            productoRepository.save(producto);
        }
    }

}
