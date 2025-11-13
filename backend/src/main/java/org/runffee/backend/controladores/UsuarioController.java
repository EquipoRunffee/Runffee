package org.runffee.backend.controladores;

import org.runffee.backend.DTO.UsuarioCrearDTO;
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

    @PostMapping("/crear")
    public void crearUsuario(@RequestBody UsuarioCrearDTO usuario) {
        usuarioService.crearUsario(usuario);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarUsuario(@PathVariable Integer id){
        usuarioService.eliminarUsuario(id);
    }

    @GetMapping("/existeEmail")
    public boolean existeEmail(@RequestParam String email) {
        return usuarioService.existeEmail(email);
    }


}
