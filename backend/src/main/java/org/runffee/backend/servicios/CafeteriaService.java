package org.runffee.backend.servicios;

import org.runffee.backend.DTO.CafeteriaDTO;
import org.runffee.backend.DTO.CafeteriaDetalleDTO;
import org.runffee.backend.modelos.Cafeteria;
import org.runffee.backend.repositorios.ICafeteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CafeteriaService {

    @Autowired
    private ICafeteriaRepository cafeteriaRepository;

    /**
     * Función que devuelve todas las cafeterías
     * @return
     */
    public List<Cafeteria> obtenerCafeterias() {
        return cafeteriaRepository.findAll()
                .stream()
                .filter(cafeteria -> !cafeteria.getEliminado())
                .toList();
    }

    /**
     * Función que devuelve la cafetería por su id
     * @param id
     * @return
     */
    public Cafeteria obtenerCafeteria(int id) {
        return cafeteriaRepository.findById(id).orElse(null);
    }

    /**
     * Función que devuelve una lista con todas las cafeterias Detalle DTO activas
     * @return
     */
    public List<CafeteriaDetalleDTO> obtenerCafeteriaDetalles() {
        return cafeteriaRepository.findAll().stream()
                .map(cafeteria -> new CafeteriaDetalleDTO(cafeteria.getNombre(), cafeteria.getImagen(), cafeteria.getTipoCafeteria()))
                .collect(Collectors.toList());
    }

    /**
     * Función para crear una cafetería
     * @param cafeteria
     */
    public void crearCafeteria(CafeteriaDTO cafeteria) {
        Cafeteria nuevaCafeteria = new Cafeteria();

        nuevaCafeteria.setNombre(cafeteria.getNombre());
        nuevaCafeteria.setDescripcion(cafeteria.getDescripcion());
        nuevaCafeteria.setLat(cafeteria.getLat());
        nuevaCafeteria.setLng(cafeteria.getLng());
        nuevaCafeteria.setImagen(cafeteria.getImagen());
        nuevaCafeteria.setTipoCafeteria(cafeteria.getTipoCafeteria());

        cafeteriaRepository.save(nuevaCafeteria);
    }

    /**
     * Función para eliminar una cafetería
     * @param id
     */
    public void eliminarCafeteria(int id) {
        Cafeteria cafeteria = cafeteriaRepository.findById(id).orElse(null);
        if (cafeteria != null) {
            cafeteria.setEliminado(true);
        }
    }

    /**
     * Función para editar una cafetería
     */
//    public void editarCafeteria(CafeteriaDTO cafeteriaDTO, int id) {
//        Cafeteria cafeteria = cafeteriaRepository.findById(id).orElse(null);
//
//        if(cliente != null){
//            cliente.setNombre(dto.getNombre());
//            cliente.setApellidos(dto.getApellidos());
//            cliente.setCorreo(dto.getCorreo());
//            cliente.setTelefono(dto.getTelefono());
//            cliente.setContrasena(dto.getContrasena());
//
//            clienteRepository.save(cliente);
//        }
//    }
}
