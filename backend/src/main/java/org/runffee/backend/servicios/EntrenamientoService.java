package org.runffee.backend.servicios;

import org.runffee.backend.DTO.EntrenamientoDTO;
import org.runffee.backend.DTO.EntrenamientoDetalleDTO;
import org.runffee.backend.DTO.EntrenamientoPerfilDTO;
import org.runffee.backend.DTO.ValoracionDTO;
import org.runffee.backend.modelos.Entrenamiento;
import org.runffee.backend.modelos.EstadoPedido;
import org.runffee.backend.modelos.Usuario;
import org.runffee.backend.repositorios.ICuponRepository;
import org.runffee.backend.repositorios.IEntrenamientoRepository;
import org.runffee.backend.repositorios.ILineaPedidoRepository;
import org.runffee.backend.repositorios.IPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EntrenamientoService {

    @Autowired
    private IEntrenamientoRepository entrenamientoRepository;

    @Autowired
    private ILineaPedidoRepository lineaPedidoRepository;
    @Autowired
    private LineaPedidoService lineaPedidoService;
    @Autowired
    private ICuponRepository cuponRepository;

    @Autowired
    private StravaService stravaService;
    @Autowired
    private IPedidoRepository iPedidoRepository;

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
        return entrenamientoRepository.obtenerEntrenamientoDetalles(idUsuario);
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
        nuevoEntrenamiento.setStravaKm(entrenamiento.getStrava_km());
        nuevoEntrenamiento.setStravaTiempo(entrenamiento.getStrava_tiempo());
        nuevoEntrenamiento.setKmObjetivo(entrenamiento.getKm_objetivo());
        nuevoEntrenamiento.setTiempoObjetivo(entrenamiento.getTiempo_objetivo());

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

    public EntrenamientoPerfilDTO obtenerEntrenamientoPerfil(Integer idEntrenamiento, Usuario usuario) {

        Entrenamiento entrenamiento = entrenamientoRepository.findById(idEntrenamiento).orElse(null);
        if(entrenamiento != null){

            EntrenamientoPerfilDTO entrenamientoPerfilDTO = entrenamientoRepository.obtenerEntrenamientoPerfil(idEntrenamiento, usuario.getId());
            entrenamientoPerfilDTO.setPedido(entrenamiento.getPedido());
            entrenamientoPerfilDTO.setLineasPedido(lineaPedidoRepository.findByPedido(entrenamiento.getPedido()));
            if(entrenamiento.getPedido().getCuponAplicado() != null){
                entrenamientoPerfilDTO.setCuponAplicado(cuponRepository.findByNombre(entrenamiento.getPedido().getCuponAplicado()));
            }
            return entrenamientoPerfilDTO;
        }
        return null;
    }

    public ResponseEntity<?> completarEntrenamiento(Integer idEntrenamiento, Usuario usuario) {

        stravaService.validarRenovarToken(usuario.getId());

        Entrenamiento entrenamiento = entrenamientoRepository.findById(idEntrenamiento).get();

        if(!entrenamiento.getCompletado() && !entrenamiento.getEliminado()){
            entrenamiento.setCompletado(true);
            Object respuesta = stravaService.obtenerEntrenamientosAtleta(usuario.getStravaAccessToken());

            if(respuesta!=null){
                List<Map<String, Object>> lista = (List<Map<String, Object>>) respuesta;

                Map<String, Object> ultimo = lista.stream()
                        .max(Comparator.comparing(a -> (String) a.get("start_date")))
                        .orElse(null);

                if(ultimo==null){
                    return ResponseEntity.ok(Map.of("estado", "Error: no se encuentra el entrenamiento"));
                }
                entrenamiento.setNombre((String) ultimo.get("name"));
                entrenamiento.setDescripcion((String) ultimo.get("timezone"));
                entrenamiento.setIdStrava(((Number) ultimo.get("id")).intValue());
                entrenamiento.setStravaKm(((Number) ultimo.get("distance")).doubleValue() / 1000.0);

                entrenamiento.setStravaTiempo((Integer) ultimo.get("moving_time"));

                Map<String, Object> mapa = (Map<String, Object>) ultimo.get("map");

                String summaryPolyline = (String) mapa.get("summary_polyline");

                entrenamiento.setUrl_mapa(summaryPolyline);

                if(entrenamiento.getStravaKm() < entrenamiento.getKmObjetivo() || entrenamiento.getStravaTiempo() > entrenamiento.getTiempoObjetivo()){
                    entrenamiento.getPedido().setEstado(EstadoPedido.CANCELADO);
                } else {
                    entrenamiento.getPedido().setEstado(EstadoPedido.APROBADO);
                }
                iPedidoRepository.save(entrenamiento.getPedido());
                entrenamientoRepository.save(entrenamiento);
            }
        }

        return ResponseEntity.ok(Map.of("completado", entrenamiento.getCompletado(), "estadoPedido", entrenamiento.getPedido().getEstado()));

    }
}