package org.runffee.backend.servicios;

import org.runffee.backend.modelos.Reto;
import org.runffee.backend.repositorios.IRetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetoService {

    @Autowired
    private IRetoRepository retoRepository;

    public List<Reto> obtenerRetos() {
        return retoRepository.findAll();
    }

}
