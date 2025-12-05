package org.runffee.backend.servicios;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.runffee.backend.modelos.Usuario;
import org.runffee.backend.repositorios.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    @Value("${jwt.secret-key}")
    private String jwtSecretKey;
    private final long jwtExpirationMs = 3 *60 * 60 * 1000;
    @Autowired
    private IUsuarioRepository usuarioRepository;

    public String genenrarToken(Integer id, String correo){
        return Jwts.builder()
                .setSubject(String.valueOf(id))
                .claim("correo", correo)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8)))
                .compact();
    }

    public Boolean validarToken(String token){
        try{
            Jwts.parserBuilder().setSigningKey(jwtSecretKey.getBytes()).build().parseClaimsJws(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Integer obtenerIdUsuario(String token){
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(jwtSecretKey.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return Integer.parseInt(claims.getSubject());
    }

    public ResponseEntity<?> renovarToken(String refreshToken){
        // Buscar usuario con ese refresh token
        Usuario usuario = usuarioRepository.obtenerUsuarioByRefreshToken(refreshToken);

        if(usuario.getExpiresat().isBefore(Instant.now())){
            throw new RuntimeException("Refresh token caducado");
        }

        // Generar nuevo access token
        String nuevoAccessToken = genenrarToken(usuario.getId(), usuario.getCorreo());

        // Guardar el nuevo token en la base de datos
        usuario.setAccesstoken(nuevoAccessToken);
        usuarioRepository.save(usuario);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", "Token actualizado");
        respuesta.put("accessToken", nuevoAccessToken);
        return ResponseEntity.ok(respuesta);
    }
}
