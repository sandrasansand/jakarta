package org.asaezc.apiservlet.webapp.compras.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.asaezc.apiservlet.webapp.compras.services.LoginService;
import org.asaezc.apiservlet.webapp.compras.services.LoginServiceSessionImpl;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LoginService auth = new LoginServiceSessionImpl();
        Optional<String> username = auth.getUsername(req);
        if (username.isPresent()) {
            HttpSession session = req.getSession();
            session.invalidate();
        }
        resp.sendRedirect(req.getContextPath() + "/login.html");
    }
}
