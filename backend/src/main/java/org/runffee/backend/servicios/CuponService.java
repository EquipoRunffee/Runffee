package org.runffee.backend.servicios;

import org.runffee.backend.modelos.Cafeteria;
import org.runffee.backend.modelos.Cupon;
import org.runffee.backend.repositorios.ICafeteriaRepository;
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

//    public Cafeteria obtenerCafeteria(int id) {
//        return cafeteriaRepository.findById(id).orElse(null);
//    }
//
//    public void eliminarCafeteria(int id) {
//        Cafeteria cafeteria = cafeteriaRepository.findById(id).orElse(null);
//        if (cafeteria != null) {
//            cafeteria.setEliminado(true);
//        }
//    }
}
