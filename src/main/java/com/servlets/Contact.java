package com.servlets;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Properties;

public class Contact extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        final String yourEmail = "kengnem070@gmail.com";
        final String appPassword = "smez fkyl ngqf lugk";
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(yourEmail, appPassword);
            }
        });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(yourEmail));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(yourEmail));
            msg.setSubject("Nouveau message de " + nom);
            msg.setText("Nom : " + nom + "\nEmail : " + email + "\n\nMessage :\n" + message);

            Transport.send(msg);

            response.setContentType("text/html");
            response.getWriter().println("<h2>Merci " + nom + ", votre message a été envoyé avec succès !</h2>");

        } catch (MessagingException e) {
            e.printStackTrace();
            response.getWriter().println("<h2>Erreur lors de l'envoi du message.</h2>");
        }
    }
}
