package org.runffee.backend.servicios;

import org.runffee.backend.DTO.RetoDTO;
import org.runffee.backend.modelos.Reto;
import org.runffee.backend.repositorios.IRetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetoService {

    @Autowired
    private IRetoRepository retoRepository;

    /**
     * Función que devuelve todos los retos
     * @return
     */
    public List<Reto> obtenerRetos() {
        return retoRepository.findAll()
                .stream()
                .filter(reto -> !reto.getEliminado())
                .toList();
    }

    /**
     * Función que devuelve un reto por su id
     * @param id
     * @return
     */
    public Reto obtenerReto(int id) {
        return retoRepository.findById(id).orElse(null);
    }

    /**
     * Función para crear un reto
     * @param reto
     */
    public void crearReto(RetoDTO reto) {
        Reto nuevoReto = new Reto();

        nuevoReto.setNombre(reto.getNombre());
        nuevoReto.setFecha_inicio(reto.getFecha_inicio());
        nuevoReto.setFecha_fin(reto.getFecha_caducidad());

        retoRepository.save(nuevoReto);
    }

    /**
     * Función para eliminar un reto por su id
     * @param id
     */
    public void eliminarReto(int id) {
        Reto reto = retoRepository.findById(id).orElse(null);
        if (reto != null) {
            reto.setEliminado(true);
        }
    }
}
