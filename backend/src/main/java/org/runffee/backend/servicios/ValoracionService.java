package org.runffee.backend.servicios;

import org.runffee.backend.DTO.ValoracionDTO;
import org.runffee.backend.modelos.*;
import org.runffee.backend.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ValoracionService {

    @Autowired
    private IValoracionRepository valoracionRepository;
    @Autowired
    private EntrenamientoService entrenamientoService;

    /**
     * Función que devuelve todas las valoraciones
     *
     * @return
     */
    public List<Valoracion> obtenerValoraciones() {
        return valoracionRepository.findAll()
                .stream()
                .filter(valoracion -> !valoracion.getEliminado())
                .toList();
    }

    /**
     * Función que devuelve la valoración por su id
     *
     * @param id
     * @return
     */
    public Valoracion obtenerValoracion(int id) {
        return valoracionRepository.findById(id).orElse(null);
    }

    /**
     * Función para crear una valoración
     *
     * @param valoracion
     */
    public void crearValoracion(ValoracionDTO valoracion) {
        Valoracion nuevaValoracion = new Valoracion();

        nuevaValoracion.setTitulo(valoracion.getTitulo());
        nuevaValoracion.setCantidad(valoracion.getCantidad());
        nuevaValoracion.setDescripcion(valoracion.getDescripcion());

        valoracionRepository.save(nuevaValoracion);
    }

    /**
     * Función para elimminar una valoración por su id
     *
     * @param id
     */
    public void eliminarValoracion(int id) {
        Valoracion valoracion = valoracionRepository.findById(id).orElse(null);
        if (valoracion != null) {
            valoracion.setEliminado(true);
        }
    }

    /*
        Funcion para obtener media de valoraciones por cafeteria,
        vamos obteniendo datos de la cafeteria seleccionada uno a uno con flatMap
        hasta valoraciones donde optenemos todas estas para calcular la media
     */
    private IProductoRepository productoRepository;
    private ILineaPedidoRepository lineaPedidoRepository;
    private IPedidoRepository pedidoRepository;

    public BigDecimal obtenerMediaValoracionCafeteria(Integer idCafeteria) {
        return valoracionRepository.obtenerMediaValoracionCafeteria(idCafeteria);
    }

    @Autowired
    private JwtService jwtService;
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private IEntrenamientoRepository entrenamientoRepository;

    public List<ValoracionDTO> obtenerValoracionEntrenamiento(Integer idUsuario) {

            List<Entrenamiento> entrenamientos = entrenamientoRepository.findByUsuarioId(idUsuario);
            List<ValoracionDTO> valoraciones = new ArrayList<>();
            for (Entrenamiento entrenamiento : entrenamientos) {
                Pedido pedido = entrenamiento.getPedido();
                LineaPedido lineaPedido = lineaPedidoRepository.findPedidoBy(pedido);
                String nombreCafeteria = lineaPedido.getProducto().getCafeteria().getNombre();
                Valoracion valoracion = entrenamiento.getPedido().getValoracion();

                ValoracionDTO valoracionDTO = new ValoracionDTO();
                valoracionDTO.setNombreCafeteria(nombreCafeteria);
                valoracionDTO.setDescripcion(valoracion.getDescripcion());
                valoracionDTO.setCantidad(valoracion.getCantidad());
                valoracionDTO.setTitulo(valoracion.getTitulo());

                valoraciones.add(valoracionDTO);
            }
            return valoraciones;
        }
    }
