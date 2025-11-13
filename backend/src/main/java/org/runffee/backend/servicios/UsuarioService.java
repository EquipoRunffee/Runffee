package org.runffee.backend.servicios;

import org.runffee.backend.DTO.UsuarioDTO;
import org.runffee.backend.modelos.Usuario;
import org.runffee.backend.repositorios.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    /**
     * Función que devuelve todos los usuarios
     * @return
     */
    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .filter(usuario -> !usuario.getEliminado())
                .toList();
    }

    /**
     * Función que devuelve el usuario por su id
     * @param id
     * @return
     */
    public Usuario obtenerUsuario(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    /**
     * Función para crear un usuario
     * @param usuario
     */
    public void crearUsario(UsuarioDTO usuario) {
        Usuario nuevoUsuario = new Usuario();

        nuevoUsuario.setNombre(usuario.getNombre());
        nuevoUsuario.setCorreo(usuario.getCorreo());
        nuevoUsuario.setContrasena(usuario.getContrasena());

        usuarioRepository.save(nuevoUsuario);
    }

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

    //funcion para comprobar que el email que me introduce el usuario esta en mi bbdd

    public boolean existeEmail(String correo) {
        return usuarioRepository.findByEmail(correo) != null;
        //mirar lode Optional para meter en vez del null isPresent (mas seguro)
    }

    public boolean existeAthleteId (Integer athleteid) {
        return usuarioRepository.findByAthleteid(athleteid) != null;
    }

}
