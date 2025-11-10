package org.runffee.backend.servicios;

import org.runffee.backend.DTO.CafeteriaCrearDTO;
import org.runffee.backend.DTO.CafeteriaDetalleCrearDTO;
import org.runffee.backend.DTO.ProductoCrearDTO;
import org.runffee.backend.DTO.ProductoDetalleCrearDTO;
import org.runffee.backend.modelos.Cafeteria;
import org.runffee.backend.modelos.Producto;
import org.runffee.backend.modelos.TipoCafeteria;
import org.runffee.backend.repositorios.ICafeteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CafeteriaService {

    @Autowired
    private ICafeteriaRepository cafeteriaRepository;

    public List<Cafeteria> obtenerCafeterias() {
        return cafeteriaRepository.findAll()
                .stream()
                .filter(cafeteria -> !cafeteria.getEliminado())
                .toList();
    }

    public Cafeteria obtenerCafeteria(int id) {
        return cafeteriaRepository.findById(id).orElse(null);
    }

    public List<CafeteriaDetalleCrearDTO> obtenerCafeteriaDetalles() {
        return cafeteriaRepository.findAll().stream()
                .map(cafeteria -> new CafeteriaDetalleCrearDTO(cafeteria.getNombre(), cafeteria.getImagen(), cafeteria.getTipoCafeteria()))
                .collect(Collectors.toList());
    }

    public void crearCafeteria(CafeteriaCrearDTO cafeteria) {
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

//    public void editarCafeteria(CafeteriaDTO cafeteriaDTO, int id) {
//        Cafeteria cafeteria = cafeteriaRepository.findById(id).orElse(null);
//
//        if(cliente != null){
//            cliente.setNombre(dto.getNombre());
//            cliente.setApellidos(dto.getApellidos());
//            cliente.setCorreo(dto.getCorreo());
//            cliente.setTelefono(dto.getTelefono());
//            cliente.setContrasena(dto.getContrasena());
//
//            clienteRepository.save(cliente);
//        }
//    }
}
