package org.runffee.backend.servicios;

import org.runffee.backend.DTO.AdminModificarUsuarioDTO;
import org.runffee.backend.config.SecurityConfig;
import org.runffee.backend.modelos.Usuario;
import org.runffee.backend.repositorios.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminModificarUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private SecurityConfig security;

    /**
     * Función que devuelve el usuario por id
     * @param id
     * @return
     */
    public AdminModificarUsuarioDTO obtenerUsuario(int id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        AdminModificarUsuarioDTO dto = new AdminModificarUsuarioDTO();
        dto.setCorreo(usuario.getCorreo());
        dto.setContrasena("");
        dto.setRol(usuario.getRole());
        dto.setEliminado(usuario.getEliminado());

        return dto;
    }

    /**
     * Función para modificar un usuario
     * @param id
     * @param dto
     */
    public void modificarUsuario(int id, AdminModificarUsuarioDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (dto.getCorreo() != null && !dto.getCorreo().isBlank()) {
            usuario.setCorreo(dto.getCorreo());
        }

        if (dto.getContrasena() != null && !dto.getContrasena().isBlank()) {
            usuario.setContrasena(security.passwordEncoder().encode(dto.getContrasena().trim()));
        }

        if (dto.getRol() != null) {
            usuario.setRole(dto.getRol());
        }

        if (dto.getEliminado() != null) {
            usuario.setEliminado(dto.getEliminado());
        }

        usuarioRepository.save(usuario);
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
}
