package org.runffee.backend.servicios;

import org.runffee.backend.DTO.UsuarioCrearDTO;
import org.runffee.backend.modelos.Cafeteria;
import org.runffee.backend.modelos.Usuario;
import org.runffee.backend.repositorios.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .filter(usuario -> !usuario.getEliminado())
                .toList();
    }

    public Usuario obtenerUsuario(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    /*
    public Usuario obtenerContrasenaUsuario(Integer id) {

    }
    */

    public void crearUsario(UsuarioCrearDTO usuario) {
        Usuario nuevoUsuario = new Usuario();

        nuevoUsuario.setNombre(usuario.getNombre());
        nuevoUsuario.setCorreo(usuario.getCorreo());
        nuevoUsuario.setContrasena(usuario.getContrasena());

        usuarioRepository.save(nuevoUsuario);
    }

    public void eliminarUsuario(int id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null) {
            usuario.setEliminado(true);
        }
    }

    //funcion para comprobar que el email que me introduce el usuario esta en mi bbdd

    public boolean existeEmail(String email) {
        return usuarioRepository.findByEmail(email) != null;
        //mirar lode Optional para meter en vez del null isPresent (mas seguro)
    }

    public boolean existeAthleteId (Integer athleteid) {
        return usuarioRepository.findByAthleteid(athleteid) != null;
    }

}
