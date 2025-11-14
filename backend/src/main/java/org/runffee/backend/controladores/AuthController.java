package org.runffee.backend.controladores;

import org.runffee.backend.modelos.Usuario;
import org.runffee.backend.repositorios.IUsuarioRepository;
import org.runffee.backend.servicios.AuthService;
import org.runffee.backend.servicios.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://anderolivos.com"
})
public class AuthController {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthService authService;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarUsuario(@RequestBody Map<String, String> request) {

        String correo = request.get("correo");
        String contrasena = request.get("contrasena");
        String stravaAccessToken = request.get("stravaAccessToken");

        return ResponseEntity.ok(authService.registrarUsuario(correo, contrasena, stravaAccessToken));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {

        String correo = request.get("correo");
        String contrasena = request.get("contrasena");

        return ResponseEntity.ok(authService.login(correo, contrasena));
    }


}
