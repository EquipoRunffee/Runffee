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
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class CorreoService {

    @Value("${email.api-key}")
    private String apiKey;

    public void pruebaCorreo() throws IOException {
        Email from = new Email("aolivosgamarra@safareyes.es");
        String subject = "Sending with SendGrid is Fun";
        Email to = new Email("anderolivosg@gmail.com");
        Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
    }

    public void bienvenida(CorreoDTO correo) throws IOException {
        Email from = new Email("aolivosgamarra@safareyes.es");
        String subject = "¡Bienvenido a Runffee! Corre, disfruta, repite.";
        Email to = new Email(correo.getCorreo());


        String htmlContenido = Files.readString(Paths.get("src/main/resources/templates/bienvenida.html"));
        htmlContenido = htmlContenido.replace("{{nombre}}", correo.getNombre());
        Content content = new Content("text/html", htmlContenido);

        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
    }
}
