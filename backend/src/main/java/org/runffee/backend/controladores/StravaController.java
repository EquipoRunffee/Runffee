package org.runffee.backend.controladores;

import org.runffee.backend.modelos.Usuario;
import org.runffee.backend.servicios.StravaService;
import org.runffee.backend.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/strava")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://www.anderolivos.com"
})
public class StravaController {

    @Autowired
    private StravaService stravaService;
    @Autowired
    private UsuarioService usuarioService;

    /***
     * API para intercambia el code del usuario por los tokens
     * @param body
     * @return
     */
    @PostMapping("/exchange")
    public ResponseEntity<?> exchangeCode(@RequestBody Map<String, String> body) {
        return stravaService.exchangeCode(body);
    }

    /**
     * API para actualizar el token del usuario
     * @param id
     */
    @PostMapping("/renovar/{id}")
    public void renovar(@PathVariable Integer id) {
        stravaService.validarRenovarToken(id);
    }
}
