package org.runffee.backend.servicios;

import org.runffee.backend.DTO.CuponCrearDTO;
import org.runffee.backend.DTO.ValoracionCrearDTO;
import org.runffee.backend.modelos.Cafeteria;
import org.runffee.backend.modelos.Cupon;
import org.runffee.backend.modelos.Valoracion;
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

    public void crearCupon(CuponCrearDTO cupon) {
        Cupon nuevoCupon = new Cupon();

        nuevoCupon.setNombre(cupon.getNombre());
        nuevoCupon.setFechaCaducidad(cupon.getFechaCaducidad());
        nuevoCupon.setTipo(cupon.getTipo());
        nuevoCupon.setUsado(cupon.getUsado());
        nuevoCupon.setImagen(cupon.getImagen());
        nuevoCupon.setPorcentaje(cupon.getPorcentaje());
        nuevoCupon.setDescripcion(cupon.getDescripcion());

        cuponRepository.save(nuevoCupon);
    }

    public void eliminarCupon(int id) {
        Cupon cupon = cuponRepository.findById(id).orElse(null);
        if (cupon != null) {
            cupon.setEliminado(true);
        }
    }
}
