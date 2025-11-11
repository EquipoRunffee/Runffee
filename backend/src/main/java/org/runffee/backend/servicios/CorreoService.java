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
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class CorreoService {

    @Value("${email.api-key}")
    private String apiKey;

    public void pruebaCorreo() throws IOException {
        Email from = new Email("runffee@gmail.com");
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
        Email from = new Email("runffee@gmail.com");
        String subject = "¡Bienvenido a Runffee! Corre, disfruta, repite.";
        Email to = new Email(correo.getCorreo());

        ClassPathResource resource = new ClassPathResource("templates/bienvenida.html");
        String html;
        try (InputStream inputStream = resource.getInputStream()) {
            html = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        }
        html = html.replace("{{nombre}}", correo.getNombre());
        Content content = new Content("text/html", html);

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
