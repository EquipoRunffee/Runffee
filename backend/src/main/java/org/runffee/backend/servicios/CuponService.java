package org.runffee.backend.servicios;

import org.runffee.backend.DTO.CuponDTO;
import org.runffee.backend.modelos.Cupon;
import org.runffee.backend.repositorios.ICuponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuponService {

    @Autowired
    private ICuponRepository cuponRepository;

    /**
     * Función que devuelve todos los cupones
     * @return
     */
    public List<Cupon> obtenerCupones() {
        return cuponRepository.findAll().stream().filter(cupon -> !cupon.getEliminado()).toList();
    }

    /**
     * Función que devuelve el cupón por su id
     * @param id
     * @return
     */
    public Cupon obtenerCupon(int id) {
        return cuponRepository.findById(id).orElse(null);
    }

    /**
     * Función para crear un nuevo cupón
     * @param cupon
     */
    public void crearCupon(CuponDTO cupon) {
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

    /**
     * Función para eliminar un cupón
     * @param id
     */
    public void eliminarCupon(int id) {
        Cupon cupon = cuponRepository.findById(id).orElse(null);
        if (cupon != null) {
            cupon.setEliminado(true);
        }
    }
}
