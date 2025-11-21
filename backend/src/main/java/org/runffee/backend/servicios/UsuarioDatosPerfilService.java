package org.runffee.backend.servicios;

import org.runffee.backend.DTO.UsuarioDatosPerfilDTO;
import org.runffee.backend.modelos.Usuario;
import org.runffee.backend.repositorios.IUsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDatosPerfilService {

    public final IUsuarioRepository usuarioRepository;

    public UsuarioDatosPerfilService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Función que devuelve datos específicos del usuario
     */

    public UsuarioDatosPerfilDTO obtenerDatosPerfil(Integer usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + usuarioId));

        UsuarioDatosPerfilDTO dto = new UsuarioDatosPerfilDTO();
        dto.setNombre(usuario.getNombre());
        dto.setApellidos(usuario.getApellidos());
        dto.setCorreo(usuario.getCorreo());
        dto.setCiudad(usuario.getCiudad());
        dto.setPais(usuario.getPais());
        dto.setSexo(usuario.getSexo());

        return dto;
    }
}
