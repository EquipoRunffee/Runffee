package org.runffee.backend.servicios;

import org.runffee.backend.DTO.RetoCrearDTO;
import org.runffee.backend.modelos.Cafeteria;
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
        return retoRepository.findAll()
                .stream()
                .filter(reto -> !reto.getEliminado())
                .toList();
    }

    public Reto obtenerReto(int id) {
        return retoRepository.findById(id).orElse(null);
    }

    public void crearReto(RetoCrearDTO reto) {
        Reto nuevoReto = new Reto();

        nuevoReto.setNombre(reto.getNombre());
        nuevoReto.setFecha_inicio(reto.getFecha_inicio());
        nuevoReto.setFecha_caducidad(reto.getFecha_caducidad());

        retoRepository.save(nuevoReto);
    }

    public void eliminarReto(int id) {
        Reto reto = retoRepository.findById(id).orElse(null);
        if (reto != null) {
            reto.setEliminado(true);
        }
    }
}
