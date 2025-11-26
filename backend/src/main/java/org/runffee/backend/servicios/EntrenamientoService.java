package org.runffee.backend.servicios;

import org.runffee.backend.DTO.EntrenamientoDTO;
import org.runffee.backend.DTO.EntrenamientoDetalleDTO;
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

    /**
     * Función que devuelve todos los entrenamientos
     * @return
     */
    public List<Entrenamiento> obtenerEntrenamientos() {
        return entrenamientoRepository.findAll()
                .stream()
                .filter(entrenamiento -> !entrenamiento.getEliminado())
                .toList();
    }

    /**
     * Función que devuelve el entrenamiento por id
     * @param id
     * @return
     */
    public Entrenamiento obtenerEntrenamiento(int id) {
        return entrenamientoRepository.findById(id).orElse(null);
    }

    /**
     * Función que devuelve todos los Entrenamientos Detalle DTO
     * @return
     */
    public List<EntrenamientoDetalleDTO> obtenerEntrenamientoDetalles(Integer idUsuario) {

        return entrenamientoRepository.findByUsuarioId(idUsuario)
                .stream()
                .filter(ent -> !ent.getEliminado())  // evita mostrar los eliminados
                .map(ent -> new EntrenamientoDetalleDTO(
                        ent.getNombre(),
                        ent.getDistancia(),
                        ent.getFecha_fin()
                ))
                .toList();
    }

    /**
     * Función para crear un entrenamiento
     * @param entrenamiento
     */
    public void crearEntrenamiento(EntrenamientoDTO entrenamiento) {
        Entrenamiento nuevoEntrenamiento = new Entrenamiento();

        nuevoEntrenamiento.setNombre(entrenamiento.getNombre());
        nuevoEntrenamiento.setFecha_inicio(entrenamiento.getFecha_inicio());
        nuevoEntrenamiento.setFecha_fin(entrenamiento.getFecha_fin());
        nuevoEntrenamiento.setUrl_mapa(entrenamiento.getUrl_mapa());
        nuevoEntrenamiento.setDescripcion(entrenamiento.getDescripcion());
        nuevoEntrenamiento.setDistancia(entrenamiento.getDistancia());

        entrenamientoRepository.save(nuevoEntrenamiento);
    }

    /**
     * Función para eliminar un entrenamiento
     * @param id
     */
    public void eliminarEntrenamiento(int id) {
        Entrenamiento entrenamiento = entrenamientoRepository.findById(id).orElse(null);
        if (entrenamiento != null) {
            entrenamiento.setEliminado(true);
        }
    }
}
