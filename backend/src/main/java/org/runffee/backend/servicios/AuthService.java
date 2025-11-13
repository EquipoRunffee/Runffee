package org.runffee.backend.servicios;

import org.runffee.backend.modelos.Usuario;
import org.runffee.backend.repositorios.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

        String accessToken = jwtService.genenrarToken(usuario.getId(), usuario.getCorreo());
        String refreshToken = UUID.randomUUID().toString();
        Instant expiresAt = Instant.now().plus(15, ChronoUnit.MINUTES);

        usuario.setAccesstoken(accessToken);
        usuario.setRefreshtoken(refreshToken);
        usuario.setExpiresat(expiresAt);

        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        usuarioRepository.save(usuario);


        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("message", "Usuario registrado correctamente");
        respuesta.put("accessToken", accessToken);
        respuesta.put("refreshToken", refreshToken);
        respuesta.put("expiresAt", expiresAt);
        return respuesta;
    }

    public Map<String, Object> login(String correo, String password) {

        Usuario usuario = usuarioRepository.findByCorreo(correo).orElseThrow(() -> new RuntimeException("Correo o contraseña incorrectos."));

        if(!passwordEncoder.matches(password, usuario.getContrasena())) {
            throw new RuntimeException("Correo o contraseña incorrectos.");
        }

        String accessToken = jwtService.genenrarToken(usuario.getId(), usuario.getCorreo());
        String refreshToken = UUID.randomUUID().toString();

        usuario.setAccesstoken(accessToken);
        usuario.setRefreshtoken(refreshToken);

        usuarioRepository.save(usuario);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("message", "Login exitoso");
        respuesta.put("token", accessToken);
        return respuesta;
    }
}
