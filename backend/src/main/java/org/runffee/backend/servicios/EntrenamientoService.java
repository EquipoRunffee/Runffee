package org.runffee.backend.servicios;

import org.runffee.backend.DTO.EntrenamientoCrearDTO;
import org.runffee.backend.DTO.EntrenamientoDetalleCrearDTO;
import org.runffee.backend.modelos.Entrenamiento;
import org.runffee.backend.repositorios.IEntrenamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntrenamientoService {

    @Autowired
    private IEntrenamientoRepository entrenamientoRepository;

    public List<Entrenamiento> obtenerEntrenamientos() {
        return entrenamientoRepository.findAll()
                .stream()
                .filter(entrenamiento -> !entrenamiento.getEliminado())
                .toList();
    }

    public Entrenamiento obtenerEntrenamiento(int id) {
        return entrenamientoRepository.findById(id).orElse(null);
    }

    public List<EntrenamientoDetalleCrearDTO> obtenerEntrenamientoDetalles() {
        return entrenamientoRepository.findAll().stream()
                .map(entrenamiento -> new EntrenamientoDetalleCrearDTO(entrenamiento.getNombre(), entrenamiento.getDistancia(), entrenamiento.getFecha_fin()))
                .collect(Collectors.toList());
    }

    public void crearEntrenamiento(EntrenamientoCrearDTO entrenamiento) {
        Entrenamiento nuevoEntrenamiento = new Entrenamiento();

        nuevoEntrenamiento.setNombre(entrenamiento.getNombre());
        nuevoEntrenamiento.setFecha_inicio(entrenamiento.getFecha_inicio());
        nuevoEntrenamiento.setFecha_fin(entrenamiento.getFecha_fin());
        nuevoEntrenamiento.setUrl_mapa(entrenamiento.getUrl_mapa());
        nuevoEntrenamiento.setDescripcion(entrenamiento.getDescripcion());
        nuevoEntrenamiento.setDistancia(entrenamiento.getDistancia());

        entrenamientoRepository.save(nuevoEntrenamiento);
    }
    public void eliminarEntrenamiento(int id) {
        Entrenamiento entrenamiento = entrenamientoRepository.findById(id).orElse(null);
        if (entrenamiento != null) {
            entrenamiento.setEliminado(true);
        }
    }
}
