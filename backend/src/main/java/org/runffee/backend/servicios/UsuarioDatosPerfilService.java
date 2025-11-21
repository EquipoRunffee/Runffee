package org.runffee.backend.servicios;

import org.runffee.backend.DTO.UsuarioDatosPerfilDTO;
import org.runffee.backend.modelos.Usuario;
import org.runffee.backend.repositorios.IEntrenamientoRepository;
import org.runffee.backend.repositorios.IUsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDatosPerfilService {

    public final IUsuarioRepository usuarioRepository;
    private final IEntrenamientoRepository entrenamientoRepository;

    public UsuarioDatosPerfilService(IUsuarioRepository usuarioRepository, IEntrenamientoRepository entrenamientoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.entrenamientoRepository = entrenamientoRepository;
    }

    /**
     * Función que devuelve datos específicos del usuario
     */

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
        dto.setTotalEntrenamientos(totalEntrenamientos);

        return dto;
    }
}
