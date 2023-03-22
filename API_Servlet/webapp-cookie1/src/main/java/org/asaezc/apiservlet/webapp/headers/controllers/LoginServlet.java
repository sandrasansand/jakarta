package org.asaezc.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;

@WebServlet({"/login", "/login.html"})
public class LoginServlet extends HttpServlet {
    final static String USERNAME = "admin";
    final static String PASSWORD = "12345";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //validación de la cookie
        Cookie[] cookies = req.getCookies() !=null ? req.getCookies(): new Cookie[0];
        //obtenemos cookies
        Optional<String> cookieOptional = Arrays.stream(cookies)
                .filter( c-> "username".equals(c.getName()))
                .map(Cookie::getValue)
                .findAny();
        if (cookieOptional.isPresent()){

            resp.setContentType("text/html");
            try (PrintWriter out = resp.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <meta charset=\"UTF-8\">");
            out.println("        <title>hola " + cookieOptional.get() + "</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("        <h1> hola " + cookieOptional.get()+ " sesión iniciada con anterioridad  </h1>");
            out.println("    </body>");
            out.println("</html>");
            out.close();
        }
        }else {
        getServletContext().getRequestDispatcher("/login.jsp").forward(req,resp);
    }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            resp.setContentType("text/html;charset=UTF-8");

            Cookie usernameCookie = new Cookie("username", username);
            resp.addCookie(usernameCookie);

            try (PrintWriter out = resp.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("        <meta charset=\"UTF-8\">");
                out.println("        <title>Login correcto</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("        <h1>Login correcto!</h1>");
                out.println("        <h3>Hola "+ username + " has iniciado sesión con éxito!</h3>");
                out.println("    </body>");
                out.println("</html>");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no esta autorizado para entrar en esta página!");
        }
    }
}
