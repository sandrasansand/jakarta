package org.asaezc.apiservlet.webapp.cdi.services;

import jakarta.inject.Inject;
import org.asaezc.apiservlet.webapp.cdi.configs.Service;
import org.asaezc.apiservlet.webapp.cdi.models.Usuario;
import org.asaezc.apiservlet.webapp.cdi.repositories.UsuarioRepository;

import java.sql.SQLException;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    private UsuarioRepository usuarioRepository;

    @Inject
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<Usuario> login(String username, String password) {
        try {
            return Optional.ofNullable(usuarioRepository.porUsername(username)).filter(u -> u.getPassword().equals(password));
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }
}
