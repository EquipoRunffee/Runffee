package org.runffee.backend.controladores;
import org.runffee.backend.DTO.UsuarioEncabezadoPerfilDTO;
import org.runffee.backend.servicios.UsuarioEncabezadoPerfilService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarioPerfil")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://www.anderolivos.com"
})
public class UsuarioEncabezadoPerfilController {

    private final UsuarioEncabezadoPerfilService usuarioEncabezadoPerfilService;

    public UsuarioEncabezadoPerfilController(UsuarioEncabezadoPerfilService usuarioEncabezadoPerfilService) {
        this.usuarioEncabezadoPerfilService = usuarioEncabezadoPerfilService;
    }

    /**
     * API que devuelve el encabezado de perfil de un usuario:
     * nombre, correo y total de entrenamientos.
     *
     * Se recibe el ID del usuario como parámetro de la URL.
     */

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEncabezadoPerfilDTO> obtenerEncabezadoPerfil(@PathVariable Integer id) {
        UsuarioEncabezadoPerfilDTO dto = usuarioEncabezadoPerfilService.obtenerEncabezadoPerfil(id);
        return ResponseEntity.ok(dto);
    }
}
