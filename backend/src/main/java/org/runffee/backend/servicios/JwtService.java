package org.runffee.backend.servicios;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret-key}")
    private String jwtSecretKey;
    private final long jwtExpirationMs = 15 * 60 * 1000;

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

    public Integer obtenerUserId(String token){
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(jwtSecretKey.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return Integer.parseInt(claims.getSubject());
    }
}
