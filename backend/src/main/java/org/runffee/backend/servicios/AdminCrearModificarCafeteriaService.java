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
        AdminCrearModificarCafeteriaDTO adminCrearModificarCafeteriaDTO = new AdminCrearModificarCafeteriaDTO();

        adminCrearModificarCafeteriaDTO.setNombre(obtenerCafeteria(id).getNombre());
        adminCrearModificarCafeteriaDTO.setDescripcion(obtenerCafeteria(id).getDescripcion());
        adminCrearModificarCafeteriaDTO.setLat(obtenerCafeteria(id).getLat());
        adminCrearModificarCafeteriaDTO.setLng(obtenerCafeteria(id).getLng());
        adminCrearModificarCafeteriaDTO.setImagen(obtenerCafeteria(id).getImagen());
        adminCrearModificarCafeteriaDTO.setTipoCafeteria(obtenerCafeteria(id).getTipoCafeteria());
        adminCrearModificarCafeteriaDTO.setEliminado(obtenerCafeteria(id).getEliminado());

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

    /**
     * Función para eliminar una cafeteria por id
     * @param id
     */



}
