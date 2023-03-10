package org.asaezc.apiservlet.webapp.cdi.services;

import org.asaezc.apiservlet.webapp.cdi.models.Usuario;

import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> login(String username, String password);
}
