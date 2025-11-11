package org.runffee.backend.controladores;

import org.runffee.backend.DTO.CorreoDTO;
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

    @PostMapping("/bienvenida")
    public void bienvenida(@RequestBody CorreoDTO correo) throws IOException {
        correoService.bienvenida(correo);
    }
}
