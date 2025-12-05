package org.runffee.backend.servicios;

import org.runffee.backend.modelos.Usuario;
import org.runffee.backend.repositorios.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminModificarUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    /**
     * Función que devuelve el usuario por id
     * @param id
     * @return
     */




    /**
     * Función para modificar un usuario
     * @param id
     * @param dto
     */




    /**
     * Función para eliminar un usuario
     * @param id
     */
    public void eliminarUsuario(int id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null) {
            usuario.setEliminado(true);
        }
    }
}
