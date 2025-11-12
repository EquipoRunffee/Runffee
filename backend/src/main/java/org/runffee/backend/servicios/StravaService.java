package org.runffee.backend.servicios;

import org.runffee.backend.modelos.Usuario;
import org.runffee.backend.repositorios.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.Map;

@Service
public class StravaService {

    @Value("${strava.client-id}")
    private String clientId;

    @Value("${strava.client-secret}")
    private String clientSecret;

    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private IUsuarioRepository usuarioRepository;

    public ResponseEntity<?> signIn(Map<String, String> body){


        String code = body.get("code");

        String url = "https://www.strava.com/oauth/token";

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("code", code);
        params.add("grant_type", "authorization_code");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        //Esto es la petición
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        ResponseEntity<Map> response = restTemplate.postForEntity(url, request, Map.class);

        //Esto es la respuesta con los datos del usuario
        Map<String, Object> data = response.getBody();
        Map<String, Object> athleteMap = (Map<String, Object>) data.get("athlete");


        //PARTE DE VALENTIN
        //CREAR FUNCIÓN QUE BUSQUE EN LA BBDD SI YA EXISTE UN USUARIO CON LA ID ATHLETE
        //Si existe el usuario ya -> Devuelvo un valor que me diga si existe -> LOGIN
        //Que no existe -> REGISTER
//
//        Boolean registrado = False;
//
//        return registrado

        //Cuando ya está en el register, comprobar que el correo no existe en la bbdd

        

        //Esto es la creación del usuario
        //Hay que crear una función para esto
        Usuario usuario = new Usuario();
        usuario.setNombre((String) athleteMap.get("firstname"));
        usuario.setCiudad((String) athleteMap.get("city"));
        usuario.setAthleteid((Integer) athleteMap.get("id"));
        usuario.setAccesstoken((String) data.get("access_token"));
        usuario.setRefreshtoken((String) data.get("refresh_token"));
        usuario.setExpiresat(Instant.ofEpochSecond(((Number) data.get("expires_at")).longValue()));
        usuario.setEliminado(false);

        usuarioRepository.save(usuario);

        return ResponseEntity.ok(data);
    }

    public void validarRenovarToken(Usuario usuario){
        if(usuario.getExpiresat().isAfter(Instant.now())){
            return;
        }

        System.out.println("Token expirado. Renovando token para " + usuario.getNombre());

        String url = "https://www.strava.com/oauth/token";

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("grant_type", "refresh_token");
        params.add("refresh_token", usuario.getRefreshtoken());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        ResponseEntity<Map> response = restTemplate.postForEntity(url, request, Map.class);

        Map<String, Object> body = response.getBody();

        usuario.setAccesstoken((String) body.get("access_token"));
        usuario.setRefreshtoken((String) body.get("refresh_token"));
        usuario.setExpiresat(Instant.ofEpochSecond(((Number) body.get("expires_at")).longValue()));

        usuarioRepository.save(usuario);
    }
}
