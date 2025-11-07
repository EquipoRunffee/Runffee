package org.runffee.backend.servicios;

import org.runffee.backend.modelos.Cafeteria;
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
        return cuponRepository.findAll().stream().filter(cupon -> !cupon.getEliminado()).toList();
    }

    public Cupon obtenerCupon(int id) {
        return cuponRepository.findById(id).orElse(null);
    }

    public void eliminarCupon(int id) {
        Cupon cupon = cuponRepository.findById(id).orElse(null);
        if (cupon != null) {
            cupon.setEliminado(true);
        }
    }
}
