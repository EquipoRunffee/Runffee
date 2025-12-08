package org.runffee.backend.servicios;

import org.runffee.backend.DTO.AdminCrearModificarCafeteriaDTO;
import org.runffee.backend.modelos.Cafeteria;
import org.runffee.backend.repositorios.ICafeteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminCrearModificarCafeteriaService {

    @Autowired
    private ICafeteriaRepository cafeteriaRepository;


    /**
     * Función que devuelve la cafeteria por id
     * @param id
     * @return
     */

    public AdminCrearModificarCafeteriaDTO obtenerCafeteria(int id) {

        Cafeteria cafeteria = cafeteriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cafeteria no encontrada"));

        AdminCrearModificarCafeteriaDTO adminCrearModificarCafeteriaDTO = new AdminCrearModificarCafeteriaDTO();


        adminCrearModificarCafeteriaDTO.setNombre(cafeteria.getNombre());
        adminCrearModificarCafeteriaDTO.setDescripcion(cafeteria.getDescripcion());
        adminCrearModificarCafeteriaDTO.setLat(cafeteria.getLat());
        adminCrearModificarCafeteriaDTO.setLng(cafeteria.getLng());
        adminCrearModificarCafeteriaDTO.setImagen(cafeteria.getImagen());
        adminCrearModificarCafeteriaDTO.setTipoCafeteria(cafeteria.getTipoCafeteria());
        adminCrearModificarCafeteriaDTO.setEliminado(cafeteria.getEliminado());

        return adminCrearModificarCafeteriaDTO;
    }


    /**
     * Función para crear una cafeteria
     * @param cafeteria
     */

    public void crearCafeteria (AdminCrearModificarCafeteriaDTO cafeteria) {
        Cafeteria nuevaCafeteria = new Cafeteria();

        nuevaCafeteria.setNombre(cafeteria.getNombre());
        nuevaCafeteria.setDescripcion(cafeteria.getDescripcion());
        nuevaCafeteria.setLat(cafeteria.getLat());
        nuevaCafeteria.setLng(cafeteria.getLng());
        nuevaCafeteria.setImagen(cafeteria.getImagen());
        nuevaCafeteria.setTipoCafeteria(cafeteria.getTipoCafeteria());
        nuevaCafeteria.setEliminado(cafeteria.getEliminado());

        cafeteriaRepository.save(nuevaCafeteria);

    }


    /**
     * Función para modificar una cafeteria
     * @param id
     * @param dto
     */

    public void modificarCafeteria (int id, AdminCrearModificarCafeteriaDTO dto) {
        Cafeteria cafeteria = cafeteriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cafeteria no encontrada"));

        cafeteria.setNombre(dto.getNombre());
        cafeteria.setDescripcion(dto.getDescripcion());
        cafeteria.setLat(dto.getLat());
        cafeteria.setLng(dto.getLng());
        cafeteria.setImagen(dto.getImagen());
        cafeteria.setTipoCafeteria(dto.getTipoCafeteria());

        cafeteriaRepository.save(cafeteria);
    }



    /**
     * Función para eliminar una cafeteria por id
     * @param id
     */

    public void eliminarCafeteria (int id){
        Cafeteria cafeteria = cafeteriaRepository.findById(id).orElse(null);
        if (cafeteria != null){
            cafeteria.setEliminado(true);
            cafeteriaRepository.save(cafeteria);
        }
    }





}
