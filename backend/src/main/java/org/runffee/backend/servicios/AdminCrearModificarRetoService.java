package org.runffee.backend.servicios;

import org.runffee.backend.DTO.AdminCrearModificarRetoDTO;
import org.runffee.backend.modelos.Reto;
import org.runffee.backend.repositorios.IRetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminCrearModificarRetoService {

    @Autowired
    private IRetoRepository retoRepository;


    /**
     * Función que devuelve el reto por id
     * @param id
     * @return
     */

    public AdminCrearModificarRetoDTO obtenerReto(int id) {

        Reto reto = retoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reto no encontrado"));

        AdminCrearModificarRetoDTO adminCrearModificarRetoDTO = new AdminCrearModificarRetoDTO();

        adminCrearModificarRetoDTO.setNombre(reto.getNombre());
        adminCrearModificarRetoDTO.setDescripcion(reto.getDescripcion());
        adminCrearModificarRetoDTO.setFecha_inicio(reto.getFecha_inicio());
        adminCrearModificarRetoDTO.setFecha_fin(reto.getFecha_fin());
        adminCrearModificarRetoDTO.setEliminado(reto.getEliminado());

        return   adminCrearModificarRetoDTO;
    }


    /**
     * Función para crear un reto
     * @param reto
     */

    public void crearReto(AdminCrearModificarRetoDTO reto) {

        Reto nuevoReto = new Reto();

        nuevoReto.setNombre(reto.getNombre());
        nuevoReto.setDescripcion(reto.getDescripcion());
        nuevoReto.setFecha_inicio(reto.getFecha_inicio());
        nuevoReto.setFecha_fin(reto.getFecha_fin());
        nuevoReto.setEliminado(reto.getEliminado());

        retoRepository.save(nuevoReto);
    }

    /**
     * Función para modificar un reto
     * @param id
     * @param dto
     */

    public void modificarReto(int id, AdminCrearModificarRetoDTO dto) {

        Reto reto = retoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reto no encontrado"));

        reto.setNombre(dto.getNombre());
        reto.setDescripcion(dto.getDescripcion());
        reto.setFecha_inicio(dto.getFecha_inicio());
        reto.setFecha_fin(dto.getFecha_fin());

        retoRepository.save(reto);
    }

    /**
     * Función para eliminar un reto por id
     * @param id
     */

    public void eliminarReto(int id) {

        Reto reto = retoRepository.findById(id).orElse(null);

        if (reto != null) {
            reto.setEliminado(true);
            retoRepository.save(reto);
        }
    }
}
