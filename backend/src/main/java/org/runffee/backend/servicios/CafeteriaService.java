package org.runffee.backend.servicios;

import org.runffee.backend.DTO.CafeteriaDTO;
import org.runffee.backend.DTO.CafeteriaDetalleDTO;
import org.runffee.backend.modelos.*;
import org.runffee.backend.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CafeteriaService {

    @Autowired
    private ICafeteriaRepository cafeteriaRepository;

    @Autowired
    private ValoracionService valoracionService;

    public List<Cafeteria> obtenerCafeterias() {
        return cafeteriaRepository.findAll()
                .stream()
                .filter(cafeteria -> !cafeteria.getEliminado())
                .toList();
    }

    public Cafeteria obtenerCafeteria(int id) {
        return cafeteriaRepository.findById(id).orElse(null);
    }

    public List<CafeteriaDetalleDTO> obtenerCafeteriaDetalles() {
        return cafeteriaRepository.findAll().stream()
                .map(cafeteria -> new CafeteriaDetalleDTO
                        (cafeteria.getNombre(), cafeteria.getImagen(), cafeteria.getTipoCafeteria(),
                                valoracionService.obtenerMediaValoracionCafeteria(cafeteria.getId())))
                .collect(Collectors.toList());
    }

    public void crearCafeteria(CafeteriaDTO cafeteria) {
        Cafeteria nuevaCafeteria = new Cafeteria();

        nuevaCafeteria.setNombre(cafeteria.getNombre());
        nuevaCafeteria.setDescripcion(cafeteria.getDescripcion());
        nuevaCafeteria.setLat(cafeteria.getLat());
        nuevaCafeteria.setLng(cafeteria.getLng());
        nuevaCafeteria.setImagen(cafeteria.getImagen());
        nuevaCafeteria.setTipoCafeteria(cafeteria.getTipoCafeteria());

        cafeteriaRepository.save(nuevaCafeteria);
    }

    public void eliminarCafeteria(int id) {
        Cafeteria cafeteria = cafeteriaRepository.findById(id).orElse(null);
        if (cafeteria != null) {
            cafeteria.setEliminado(true);
        }
    }

    //crear cafdto vacia nueva


}
