package org.runffee.backend.servicios;

import org.runffee.backend.modelos.Cafeteria;
import org.runffee.backend.modelos.Entrenamiento;
import org.runffee.backend.repositorios.IEntrenamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenamientoService {

    @Autowired
    private IEntrenamientoRepository entrenamientoRepository;

    public List<Entrenamiento> obtenerEntrenamientos() {
        return entrenamientoRepository.findAll()
                .stream()
                .filter(entrenamiento -> !entrenamiento.getEliminado())
                .toList();
    }

    public Entrenamiento obtenerEntrenamiento(int id) {
        return entrenamientoRepository.findById(id).orElse(null);
    }

    public void eliminarEntrenamiento(int id) {
        Entrenamiento entrenamiento = entrenamientoRepository.findById(id).orElse(null);
        if (entrenamiento != null) {
            entrenamiento.setEliminado(true);
        }
    }



}
