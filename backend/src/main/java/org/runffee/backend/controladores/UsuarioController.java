package org.runffee.backend.controladores;

import org.runffee.backend.DTO.UsuarioDTO;
import org.runffee.backend.modelos.Usuario;
import org.runffee.backend.repositorios.IUsuarioRepository;
import org.runffee.backend.servicios.JwtService;
import org.runffee.backend.servicios.UsuarioDatosPerfilService;
import org.runffee.backend.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://www.anderolivos.com"
})
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private UsuarioDatosPerfilService usuarioDatosPerfilService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private IUsuarioRepository usuarioRepository;


    /**
     * API que devuelve una lista con todos los usuarios
     * @return
     */
    @GetMapping
    public List<Usuario> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    /**
     * API que devuelve el usuario por su id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Usuario obtenerUsuarioPorId(@PathVariable int id) {
        return usuarioService.obtenerUsuario(id);
    }

    /**
     * API para crear un usuario nuevo
     * @param usuario
     */
    @PostMapping("/crear")
    public void crearUsuario(@RequestBody UsuarioDTO usuario) {
        usuarioService.crearUsario(usuario);
    }

    /**
     * API para eliminar un usuario por su id
     * @param id
     */
    @DeleteMapping("/eliminar/{id}")
    public void eliminarUsuario(@PathVariable Integer id){
        usuarioService.eliminarUsuario(id);
    }

    @GetMapping("/existe_correo")
    public boolean existeCorreo(@RequestParam String correo) {
        return usuarioService.existeCorreo(correo);
    }

    /**
     * API que devuelve datos de perfil de un usuario:
     * nombre, apellidos, correo, ciudad, pais, sexo.
     *
     * @param - accesstoken
     */

    @GetMapping("/datos_perfil")
    public Object obtenerUsuarioDatosPerfil(@RequestHeader(value = "Authorization", required = false) String authHeader){

        if(authHeader != null && authHeader.startsWith("Bearer ")){
            String token = authHeader.substring(7);
            Integer idUsuario = jwtService.obtenerIdUsuario(token);
            Usuario usuario = usuarioRepository.findById(idUsuario).get();

            if(!jwtService.validarToken(token)){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of("error", "Token expirado"));
            }

            return usuarioDatosPerfilService.obtenerDatosPerfil(idUsuario);
        }

        return null;
    }
}
