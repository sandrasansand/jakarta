package asaezc.apiservlet.webapp.jdbc.bootstrap.services;



import asaezc.apiservlet.webapp.jdbc.bootstrap.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> login(String username, String password);

    List<Usuario> listar();

    Optional<Usuario> porId(Long id);

    void guardar(Usuario usuario);

    void eliminar(Long id);
}
