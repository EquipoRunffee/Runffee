package org.runffee.backend.servicios;

import org.runffee.backend.modelos.Cafeteria;
import org.runffee.backend.repositorios.ICafeteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CafeteriaService {

    @Autowired
    private ICafeteriaRepository cafeteriaRepository;

    public List<Cafeteria> obtenerCafeterias() {
        return cafeteriaRepository.findAll();
    }

}
