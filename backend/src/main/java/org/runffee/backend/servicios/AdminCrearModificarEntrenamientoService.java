package org.runffee.backend.servicios;

import org.runffee.backend.DTO.AdminCrearModificarEntrenamientoDTO;
import org.runffee.backend.modelos.Entrenamiento;
import org.runffee.backend.repositorios.IEntrenamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminCrearModificarEntrenamientoService {

    @Autowired
    private IEntrenamientoRepository entrenamientoRepository;

    /**
     * Función que devuelve un entrenamiento por id
     * @param id
     * @return
     */
    public AdminCrearModificarEntrenamientoDTO obtenerEntrenamiento(int id) {

        Entrenamiento entrenamiento = entrenamientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrenamiento no encontrado"));

        AdminCrearModificarEntrenamientoDTO dto = new AdminCrearModificarEntrenamientoDTO();

        dto.setNombre(entrenamiento.getNombre());
        dto.setFecha_inicio(entrenamiento.getFecha_inicio());
        dto.setFecha_fin(entrenamiento.getFecha_fin());
        dto.setKmObjetivo(entrenamiento.getKmObjetivo());
        dto.setTiempoObjetivo(entrenamiento.getTiempoObjetivo());
        dto.setCompletado(entrenamiento.getCompletado());
        dto.setEliminado(entrenamiento.getEliminado());

        return dto;
    }

    /**
     * Función para modificar un entrenamiento
     * @param id
     * @param dto
     */
    public void modificarEntrenamiento(int id, AdminCrearModificarEntrenamientoDTO dto) {

        Entrenamiento entrenamiento = entrenamientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrenamiento no encontrado"));

        entrenamiento.setNombre(dto.getNombre());
        entrenamiento.setFecha_inicio(dto.getFecha_inicio());
        entrenamiento.setFecha_fin(dto.getFecha_fin());
        entrenamiento.setKmObjetivo(dto.getKmObjetivo());
        entrenamiento.setTiempoObjetivo(dto.getTiempoObjetivo());
        entrenamiento.setCompletado(dto.getCompletado());

        entrenamientoRepository.save(entrenamiento);
    }
}
