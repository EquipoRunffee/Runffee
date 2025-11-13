package org.runffee.backend.servicios;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.runffee.backend.DTO.CorreoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Service
public class CorreoService {

    /**
     * Clave de nuestra API de SendGrid (guardada en el Environments de nuestro Servidor de Spring Boot)
     */
    @Value("${email.api-key}")
    private String apiKey;

    /**
     * Función que envía el correo de Bienvenida al usuario
     * @param correo
     * @throws IOException
     */
    public void bienvenida(CorreoDTO correo) throws IOException {
        //Indicamos desde donde vamos a enviar el correo
        Email from = new Email("runffee@gmail.com");

        //Indicamos el asunto del correo
        String subject = "¡Bienvenido a Runffee! Corre, disfruta, repite.";
        Email to = new Email(correo.getCorreo());

        //Indicamos la ruta de nuestro html
        ClassPathResource resource = new ClassPathResource("templates/bienvenida.html");

        //Convertimos nuestro html en string
        String html;
        try (InputStream inputStream = resource.getInputStream()) {
            html = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        }

        //Introducir el nombre del usuario en el html
        html = html.replace("{{nombre}}", correo.getNombre());
        Content content = new Content("text/html", html);

        //Creamos el correo
        Mail mail = new Mail(from, subject, to, content);

        //Llamamos a la API de SendGrid para enviar el email
        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
        } catch (IOException ex) {
            throw ex;
        }
    }
}
