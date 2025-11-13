package org.runffee.backend.servicios;

import org.runffee.backend.modelos.Usuario;
import org.runffee.backend.repositorios.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.Map;

@Service
public class StravaService {

    /**
     * STRAVA-CLIENT-ID y STRAVA-CLIENT-SECRET se encuentran en el Environments de Render (nuestro servidor de SpringBoot)
     */
    @Value("${strava.client-id}")
    private String clientId;

    @Value("${strava.client-secret}")
    private String clientSecret;

    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioService usuarioService;

    /**
     * Función para cambiar el code del usuario por sus tokens
     * @param body
     * @return
     */
    public ResponseEntity<?> exchangeCode(Map<String, String> body){

        //Obtenemos el code del usuario
        String code = body.get("code");

        //La url de la API a la que tenemos que llamar para intercambiar el code por el token
        String url = "https://www.strava.com/oauth/token";

        //Mapa con los datos de nuestra aplicación de Strava
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("code", code);
        params.add("grant_type", "authorization_code");

        //Creamos el encabezado de nuestra petición
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        //Creamos la petición
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        //Realizamos la petición
        ResponseEntity<Map> response = restTemplate.postForEntity(url, request, Map.class);

        //Recibimos los datos recibidos y los guardamos en data
        Map<String, Object> data = response.getBody();
        //Dentro de data tenemos dentor el objeto athlete el cual nos interesa guardar en una variable
        Map<String, Object> athleteMap = (Map<String, Object>) data.get("athlete");


        //PARTE DE VALENTIN
        //CREAR FUNCIÓN QUE BUSQUE EN LA BBDD SI YA EXISTE UN USUARIO CON LA ID ATHLETE
        //Si existe el usuario ya -> Devuelvo un valor que me diga si existe -> Para redirigir al LOGIN
        //Que no existe -> Lo redirijo a la pagina del REGISTER
//
//        Boolean registrado = False;
//
//        return registrado

        Integer athleteid = (Integer) athleteMap.get("id");

        if (usuarioService.existeAthleteId(athleteid)){
            return ResponseEntity.ok(Map.of("status", "login")); //debe ir al login
        }


        //Cuando ya está en el register, comprobar que el correo no existe en la bbdd

        

        //En el caso de que el usuario no exista en nuestra bbdd y no exista ningún correo tampoco
        //Creamos el usuario en la bbdd
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

        return ResponseEntity.ok(Map.of("status","register")); //return.. ("usuarioNuevo")??(Map.of("status", "register") ???
    }




    /**
     * Función para validar si el token está activo. Si no lo está, lo renueva automáticamente
     * @param id
     */
    public void validarRenovarToken(Integer id){
        //Obtenemos el usuario con dicha id
        Usuario usuario = usuarioService.obtenerUsuario(id);
        //Si la fecha de expiración está después de la fecha actual (es decir, aún está activo el token)
        // , pues salimos de la función porque está todo correcto
        if(usuario.getExpiresat().isAfter(Instant.now())){
            return;
        }

        //Si llegamos a esta parte es porque el token ha caducado
        System.out.println("Token expirado. Renovando token para " + usuario.getNombre());

        //URL de la API para actualizar el token
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

        //Actualizamos los campos del token en la bbdd
        usuario.setAccesstoken((String) body.get("access_token"));
        usuario.setRefreshtoken((String) body.get("refresh_token"));
        usuario.setExpiresat(Instant.ofEpochSecond(((Number) body.get("expires_at")).longValue()));

        usuarioRepository.save(usuario);
    }
}
