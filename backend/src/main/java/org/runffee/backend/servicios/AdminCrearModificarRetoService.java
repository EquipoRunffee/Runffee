package org.runffee.backend.servicios;

import org.runffee.backend.DTO.AdminCrearModificarRetoDTO;
import org.runffee.backend.repositorios.IRetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminCrearModificarRetoService {

    @Autowired
    private IRetoRepository iRetoRepository;


    /**
     * Función que devuelve el reto por id
     * @param id
     * @return
     */

    public AdminCrearModificarRetoDTO obtenerReto(int id) {
        AdminCrearModificarRetoDTO adminCrearModificarRetoDTO = new AdminCrearModificarRetoDTO();

        adminCrearModificarRetoDTO.setNombre(obtenerReto(id).getNombre());
        adminCrearModificarRetoDTO.setDescripcion(obtenerReto(id).getDescripcion());
        adminCrearModificarRetoDTO.setFecha_inicio(obtenerReto(id).getFecha_inicio());
        adminCrearModificarRetoDTO.setFecha_caducidad(obtenerReto(id).getFecha_caducidad());
        adminCrearModificarRetoDTO.setEliminado(obtenerReto(id).getEliminado());

        return   adminCrearModificarRetoDTO;
    }


    /**
     * Función para crear un reto
     * @param producto
     */




    /**
     * Función para modificar un reto
     * @param id
     * @param dto
     */

    /**
     * Función para eliminar un reto por id
     * @param id
     */
}
