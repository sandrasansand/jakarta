package org.asaezc.apiservlet.webapp.session.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

public class LoginServiceSessionImpl implements LoginService{
    @Override
    public Optional<String> getUsername(HttpServletRequest request) {
        //utilizamos obj session
        HttpSession session = request.getSession();
        //casteamos y obtenemos el username
        String username = (String) session.getAttribute("username");
        if (username != null) {
            //convertimos en un Optional
            return Optional.of(username);
        }
        return Optional.empty();
    }
}
