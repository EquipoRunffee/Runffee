package org.runffee.backend.controladores;

import org.runffee.backend.modelos.Usuario;
import org.runffee.backend.repositorios.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/strava")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://anderolivos.com"
})
public class StravaController {

    @Value("${strava.client-id}")
    private String clientId;

    @Value("${strava.client-secret}")
    private String clientSecret;

    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @PostMapping("/exchange")
    public ResponseEntity<?> exchangeCode(@RequestBody Map<String, String> body) {

        String code = body.get("code");

        String url = "https://www.strava.com/oauth/token";

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("code", code);
        params.add("grant_type", "authorization_code");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        ResponseEntity<Map> response = restTemplate.postForEntity(url, request, Map.class);

        Map<String, Object> data = response.getBody();
        Map<String, Object> athleteMap = (Map<String, Object>) data.get("athlete");

        Usuario usuario = new Usuario();
        usuario.setNombre((String) athleteMap.get("firstname"));
        usuario.setCiudad((String) athleteMap.get("city"));
        usuario.setAthleteid((Integer) athleteMap.get("id"));
        usuario.setAccesstoken((String) data.get("access_token"));
        usuario.setRefreshtoken((String) data.get("refresh_token"));
        usuario.setExpiresat(Instant.ofEpochSecond(((Number) data.get("expires_at")).longValue()));
        usuario.setEliminado(false);

        usuarioRepository.save(usuario);

        return ResponseEntity.ok(usuario);
    }

}
