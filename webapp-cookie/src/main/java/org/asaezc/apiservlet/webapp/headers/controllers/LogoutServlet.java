package org.asaezc.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.asaezc.apiservlet.webapp.headers.services.LoginService;
import org.asaezc.apiservlet.webapp.headers.services.LoginServiceImpl;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LoginService auth = new LoginServiceImpl();
        Optional<String> username = auth.getUsername(req);
        if (username.isPresent()) {
            //eliminar cookie es dejarla vacía y tiempo de expirar a 0
            Cookie usernameCookie = new Cookie("username", "");
            usernameCookie.setMaxAge(0);
            //asignación a la respuesta
            resp.addCookie(usernameCookie);
        }
        resp.sendRedirect(req.getContextPath() + "/login.html");
    }
}
