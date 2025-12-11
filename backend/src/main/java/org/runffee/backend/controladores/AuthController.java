package org.runffee.backend.controladores;

import org.runffee.backend.DTO.CorreoDTO;
import org.runffee.backend.modelos.Usuario;
import org.runffee.backend.repositorios.IUsuarioRepository;
import org.runffee.backend.servicios.AuthService;
import org.runffee.backend.servicios.CorreoService;
import org.runffee.backend.servicios.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://www.anderolivos.com",
        "https://anderolivos.com"
})
public class AuthController {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private AuthService authService;
    @Autowired
    private CorreoService correoService;

    private Map<String, String> otpStorage = new ConcurrentHashMap<>();
    private Map<String, Map<String, String>> registrosPendientes = new ConcurrentHashMap<>();

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarUsuario(@RequestBody Map<String, String> request) {

        String correo = request.get("correo");
        String contrasena = request.get("contrasena");
        String stravaAccessToken = request.get("stravaAccessToken");

        String otp = String.valueOf(100000 + new Random().nextInt(900000));
        otpStorage.put(correo, otp);

        CorreoDTO dto = new CorreoDTO();
        dto.setCorreo(correo);
        dto.setNombre("Usuario");

        try {
            correoService.verificacion(dto, otp);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError()
                    .body("Error enviando correo de verificación");
        }

        Map<String, String> usuarioPendiente = new HashMap<>();
        usuarioPendiente.put("correo", correo);
        usuarioPendiente.put("contrasena", contrasena);
        usuarioPendiente.put("stravaAccessToken", stravaAccessToken);

        registrosPendientes.put(correo, usuarioPendiente);

        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "Usuario registrado. Se ha enviado un correo con un código de verificación.");

        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {

        String correo = request.get("correo");
        String contrasena = request.get("contrasena");

        return ResponseEntity.ok(authService.login(correo, contrasena));
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody Map<String, String> request) {
        return ResponseEntity.ok(jwtService.renovarToken(request.get("refreshToken")));
    }

    @PostMapping("/verificar-otp")
    public ResponseEntity<?> verificarOtp(@RequestBody Map<String, String> request) throws IOException {
        String correo = request.get("correo");
        String otp = request.get("otp");

        String storedOtp = otpStorage.get(correo);
        if (storedOtp == null) return ResponseEntity.badRequest().body("No se encontró OTP");
        if (!storedOtp.equals(otp)) return ResponseEntity.badRequest().body("OTP incorrecto");

        Map<String, String> datosPendientes = registrosPendientes.get(correo);
        if (datosPendientes != null) {
            authService.registrarUsuario(
                    datosPendientes.get("correo"),
                    datosPendientes.get("contrasena"),
                    datosPendientes.get("stravaAccessToken")
            );
            registrosPendientes.remove(correo);
        }

        otpStorage.remove(correo);
        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "Usuario verificado correctamente");
        return ResponseEntity.ok(response);
    }

}
