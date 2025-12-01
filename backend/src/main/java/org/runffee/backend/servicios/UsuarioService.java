package org.runffee.backend.servicios;

import org.runffee.backend.DTO.UsuarioDTO;
import org.runffee.backend.DTO.UsuarioDatosPerfilDTO;
import org.runffee.backend.modelos.Usuario;
import org.runffee.backend.repositorios.IEntrenamientoRepository;
import org.runffee.backend.repositorios.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IEntrenamientoRepository  entrenamientoRepository;

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

    public Boolean existeCorreo(String correo) {
        return usuarioRepository.existsByCorreo(correo);
        //mirar lode Optional para meter en vez del null isPresent (mas seguro)
    }

    public boolean existeStravaAthleteId (Integer stravaAthleteid) {
        return usuarioRepository.existsByStravaAthleteId(stravaAthleteid);
    }

    public UsuarioDatosPerfilDTO obtenerDatosPerfil(Integer usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + usuarioId));

        Integer totalEntrenamientos = entrenamientoRepository.countByUsuarioId(usuarioId);

        UsuarioDatosPerfilDTO dto = new UsuarioDatosPerfilDTO();
        dto.setNombre(usuario.getNombre());
        dto.setApellidos(usuario.getApellidos());
        dto.setCorreo(usuario.getCorreo());
        dto.setCiudad(usuario.getCiudad());
        dto.setPais(usuario.getPais());
        dto.setSexo(usuario.getSexo());
        dto.setImagen(usuario.getImagen());
        dto.setTotalEntrenamientos(totalEntrenamientos);

        return dto;
    }

}
