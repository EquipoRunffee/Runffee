package org.runffee.backend.servicios;

import org.runffee.backend.modelos.Cupon;
import org.runffee.backend.repositorios.ICuponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuponService {

    @Autowired
    private ICuponRepository cuponRepository;

    public List<Cupon> obtenerCupones() {
        return cuponRepository.findAll();
    }

}
