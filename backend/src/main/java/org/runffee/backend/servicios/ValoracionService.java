package org.runffee.backend.servicios;

import org.runffee.backend.modelos.Valoracion;
import org.runffee.backend.repositorios.IValoracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValoracionService {

    @Autowired
    private IValoracionRepository valoracionRepository;

    public List<Valoracion> obtenerValoraciones() {
        return valoracionRepository.findAll();
    }

}
