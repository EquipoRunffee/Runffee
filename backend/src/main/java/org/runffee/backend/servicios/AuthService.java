package org.runffee.backend.servicios;

import org.runffee.backend.modelos.Usuario;
import org.runffee.backend.modelos.UsuarioSexo;
import org.runffee.backend.repositorios.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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


    private final RestTemplate restTemplate = new RestTemplate();


    public Map<String, Object> registrarUsuario(String correo, String contrasena, String stravaAccessToken) {

        //Obtenemos el usuario por su token
        Usuario usuario = usuarioRepository.findByStravaAccessToken(stravaAccessToken);

        //Si el usuario obtenido ya tiene un correo significa que ya estaba registrado
        if (usuario.getCorreo() != null) {
            throw new RuntimeException("El correo ya está registrado");
        }

        //Guardamos el correo y contraseña del usuario
        usuario.setCorreo(correo);
        usuario.setContrasena(passwordEncoder.encode(contrasena));

        //Creamos el token interno
        String accessToken = jwtService.genenrarToken(usuario.getId(), usuario.getCorreo());
        String refreshToken = UUID.randomUUID().toString();
        Instant expiresAt = Instant.now().plus(15, ChronoUnit.MINUTES);

        //Guardamos el token interno
        usuario.setAccesstoken(accessToken);
        usuario.setRefreshtoken(refreshToken);
        usuario.setExpiresat(expiresAt);

        // URL de Strava para obtener los datos del atleta autenticado
        String url = "https://www.strava.com/api/v3/athlete";

        //La cabezera de nuestra petición
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + stravaAccessToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Creamos el encabezado de la petición
        HttpEntity<String> request = new HttpEntity<>(headers);

        // Realizas la petición GET
        ResponseEntity<Map> atleta = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                Map.class
        );

        Map atletaBody = atleta.getBody();

        //Guardamos los datos del usuario
        usuario.setStravaAthleteId((Integer)atletaBody.get("id"));
        usuario.setNombre(atletaBody.get("firstname").toString()+" "+atletaBody.get("lastname").toString());
        usuario.setCiudad(atletaBody.get("city").toString());
        usuario.setPais(atletaBody.get("country").toString());
        usuario.setSexo((UsuarioSexo) atletaBody.get("sex"));
        usuario.setImagen(atletaBody.get("profile").toString());

        //Guardamos el usuario creado
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
