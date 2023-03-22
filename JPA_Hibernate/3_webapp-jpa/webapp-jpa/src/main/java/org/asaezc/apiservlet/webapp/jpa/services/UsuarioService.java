package org.asaezc.apiservlet.webapp.jpa.services;

import org.asaezc.apiservlet.webapp.jpa.models.entities.Usuario;

import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> login(String username, String password);
}
