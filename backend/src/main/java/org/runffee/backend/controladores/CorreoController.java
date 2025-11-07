package org.runffee.backend.controladores;

import org.runffee.backend.servicios.CorreoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class CorreoController {
    @Autowired
    private CorreoService correoService;

    @PostMapping("/enviar")
    public String enviarCorreo(@RequestParam String to, @RequestParam String subject, @RequestParam String body) {
        correoService.enviarCorreo(to, subject, body);
        return "Correo enviado correctamente a " + to;
    }
}
