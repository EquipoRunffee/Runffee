package org.runffee.backend.controladores;

import org.runffee.backend.DTO.UsuarioDTO;
import org.runffee.backend.DTO.UsuarioDatosPerfilDTO;
import org.runffee.backend.DTO.UsuarioEncabezadoPerfilDTO;
import org.runffee.backend.modelos.Usuario;
import org.runffee.backend.servicios.UsuarioDatosPerfilService;
import org.runffee.backend.servicios.UsuarioEncabezadoPerfilService;
import org.runffee.backend.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    private UsuarioEncabezadoPerfilService usuarioEncabezadoPerfilService;
    @Autowired
    private UsuarioDatosPerfilService usuarioDatosPerfilService;


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
     * API que devuelve el encabezado de perfil de un usuario:
     * nombre, correo y total de entrenamientos.
     *
     * @param id
     */
    @GetMapping("/encabezado_perfil/{id}")
    public ResponseEntity<UsuarioEncabezadoPerfilDTO> obtenerEncabezadoPerfil(@PathVariable Integer id) {
        UsuarioEncabezadoPerfilDTO dto = usuarioEncabezadoPerfilService.obtenerEncabezadoPerfil(id);
        return ResponseEntity.ok(dto);
    }

    /**
     * API que devuelve datos de perfil de un usuario:
     * nombre, apellidos, correo, ciudad, pais, sexo.
     *
     * @param id
     */
    @GetMapping("/datos_perfil/{id}")
    public ResponseEntity<UsuarioDatosPerfilDTO> obtenerDatosPerfil(@PathVariable Integer id) {
        UsuarioDatosPerfilDTO dto = usuarioDatosPerfilService.obtenerDatosPerfil(id);
        return ResponseEntity.ok(dto);
    }
}
