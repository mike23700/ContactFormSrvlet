package com.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Contact extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        System.out.println("Nom: " + nom);
        System.out.println("Email: " + email);
        System.out.println("Message: " + message);

        response.setContentType("text/html");
        response.getWriter().println("<h2>Merci pour votre message, " + nom + "!</h2>");
    }
}
