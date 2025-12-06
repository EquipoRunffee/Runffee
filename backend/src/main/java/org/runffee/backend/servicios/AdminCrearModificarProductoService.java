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
    public AdminCrearModificarProductoDTO obtenerProductoDTO(int id) {

        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        AdminCrearModificarProductoDTO dto = new AdminCrearModificarProductoDTO();

        dto.setDescripcion(producto.getDescripcion());
        dto.setEliminado(producto.getEliminado());
        dto.setImagen(producto.getImagen());
        dto.setNombre(producto.getNombre());
        dto.setPrecio(producto.getPrecio());
        dto.setTipoProducto(producto.getTipoProducto());

        if (producto.getCafeteria() != null) {
            Cafeteria cafeteria = cafeteriaRepository.findById(producto.getCafeteria().getId())
                    .orElse(null);
            if (cafeteria != null) {
                dto.setIdCafeteria(cafeteria.getId());
            } else {
                dto.setIdCafeteria(null);
            }
        } else {
            dto.setIdCafeteria(null);
        }

        return dto;
    }


    /**
     * Función para crear un producto
     * @param producto
     */
    public void crearProducto(AdminCrearModificarProductoDTO producto) {
        Cafeteria cafeteria = cafeteriaRepository.findById(producto.getIdCafeteria()).orElse(null);
        if (cafeteria != null) {
            Producto nuevoProducto = new Producto();

            nuevoProducto.setDescripcion(producto.getDescripcion());
            nuevoProducto.setEliminado(producto.getEliminado());
            nuevoProducto.setCafeteria(cafeteria);
            nuevoProducto.setImagen(producto.getImagen());
            nuevoProducto.setNombre(producto.getNombre());
            nuevoProducto.setPrecio(producto.getPrecio());
            nuevoProducto.setTipoProducto(producto.getTipoProducto());

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

            producto.setDescripcion(dto.getDescripcion());
            producto.setEliminado(dto.getEliminado());
            producto.setCafeteria(cafeteria);
            producto.setImagen(dto.getImagen());
            producto.setNombre(dto.getNombre());
            producto.setPrecio(dto.getPrecio());
            producto.setTipoProducto(dto.getTipoProducto());

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
