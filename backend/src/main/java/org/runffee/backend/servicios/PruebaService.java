package org.runffee.backend.servicios;
import org.runffee.backend.modelos.Prueba;
import org.runffee.backend.repositorios.IPruebaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PruebaService {
    @Autowired
    private IPruebaRepository pruebaRepository;

    public List<Prueba> obtenerPruebas() {
        return pruebaRepository.findAll();
    }
}
