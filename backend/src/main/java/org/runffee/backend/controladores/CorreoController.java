package org.runffee.backend.controladores;

import org.runffee.backend.servicios.CorreoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/mail")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://www.anderolivos.com"
})
public class CorreoController {
    @Autowired
    private CorreoService correoService;

    @GetMapping("/enviar")
    public String enviarCorreo() throws IOException {
        correoService.pruebaCorreo();
        return "Correo enviado correctamente";
    }
}
