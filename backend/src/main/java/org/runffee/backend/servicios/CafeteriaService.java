package org.runffee.backend.servicios;

import org.runffee.backend.modelos.Cafeteria;
import org.runffee.backend.modelos.TipoCafeteria;
import org.runffee.backend.repositorios.ICafeteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void eliminarCafeteria(int id) {
        Cafeteria cafeteria = cafeteriaRepository.findById(id).orElse(null);
        if (cafeteria != null) {
            cafeteria.setEliminado(true);
        }
    }


    //PENDIENTE CREACION DE DTO (Iván)
//    public void crearCafeteria(CafeteriaDTO cafeteriaDTO) {
//
//    }

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
