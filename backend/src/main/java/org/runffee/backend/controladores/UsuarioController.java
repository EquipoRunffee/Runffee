package org.runffee.backend.controladores;

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

    @GetMapping
    public List<Usuario> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario obtenerUsuarioPorId(@PathVariable int id) {
        return usuarioService.obtenerUsuario(id);
    }
}
