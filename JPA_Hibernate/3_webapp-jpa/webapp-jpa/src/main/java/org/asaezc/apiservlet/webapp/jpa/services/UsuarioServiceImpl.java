package org.asaezc.apiservlet.webapp.jpa.services;

import jakarta.inject.Inject;
import org.asaezc.apiservlet.webapp.jpa.configs.Service;
import org.asaezc.apiservlet.webapp.jpa.interceptors.TransactionalJpa;
import org.asaezc.apiservlet.webapp.jpa.models.entities.Usuario;
import org.asaezc.apiservlet.webapp.jpa.repositories.RepositoryJpa;
import org.asaezc.apiservlet.webapp.jpa.repositories.UsuarioRepository;

import java.util.Optional;

@Service
@TransactionalJpa
public class UsuarioServiceImpl implements UsuarioService{
    private UsuarioRepository usuarioRepository;

    @Inject
    public UsuarioServiceImpl(@RepositoryJpa UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<Usuario> login(String username, String password) {
        try {
            return Optional.ofNullable(usuarioRepository.porUsername(username)).filter(u -> u.getPassword().equals(password));
        } catch (Exception throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }
}
