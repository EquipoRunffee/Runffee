package org.runffee.backend.servicios;

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
        return entrenamientoRepository.findAll();
    }

}
