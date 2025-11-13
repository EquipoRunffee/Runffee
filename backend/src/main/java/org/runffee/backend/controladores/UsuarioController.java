package org.runffee.backend.controladores;

import org.runffee.backend.DTO.UsuarioDTO;
import org.runffee.backend.modelos.Usuario;
import org.runffee.backend.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/existeEmail")
    public boolean existeEmail(@RequestParam String correo) {
        return usuarioService.existeEmail(correo);
    }


}
