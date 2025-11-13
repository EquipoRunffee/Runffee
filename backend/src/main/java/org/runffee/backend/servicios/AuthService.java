package org.runffee.backend.servicios;

import org.runffee.backend.modelos.Usuario;
import org.runffee.backend.repositorios.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private JwtService jwtService;

    public Map<String, Object> registrarUsuario(Usuario usuario) {
        if (usuarioRepository.findByCorreo(usuario.getCorreo()).isPresent()) {
            throw new RuntimeException("El correo ya está registrado");
        }

        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        usuarioRepository.save(usuario);

        String token = jwtService.genenrarToken(usuario.getId(), usuario.getCorreo());

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Usuario registrado correctamente");
        response.put("token", token);
        return response;
    }

    public String login(String correo, String password) {
        return "Usuario logueado";
    }
}
