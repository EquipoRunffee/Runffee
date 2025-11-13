package org.runffee.backend.servicios;

import org.runffee.backend.DTO.UsuarioEncabezadoPerfilDTO;
import org.runffee.backend.modelos.Usuario;
import org.runffee.backend.repositorios.IEntrenamientoRepository;
import org.runffee.backend.repositorios.IUsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioEncabezadoPerfilService {

    private final IUsuarioRepository usuarioRepository;
    private final IEntrenamientoRepository entrenamientoRepository;

    public UsuarioEncabezadoPerfilService(IUsuarioRepository usuarioRepository, IEntrenamientoRepository entrenamientoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.entrenamientoRepository = entrenamientoRepository;
    }

    /**
     * Función que devuelve "nombre", "correo" y "número de entrenamientos realizados" del usuario
     */

    public UsuarioEncabezadoPerfilDTO obtenerEncabezadoPerfil(Integer usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + usuarioId));

        Integer totalEntrenamientos = entrenamientoRepository.countByUsuarioId(usuarioId);

        UsuarioEncabezadoPerfilDTO dto = new UsuarioEncabezadoPerfilDTO();
        dto.setNombre(usuario.getNombre());
        dto.setCorreo(usuario.getCorreo());
        dto.setTotalEntrenamientos(totalEntrenamientos);

        return dto;
    }

}
