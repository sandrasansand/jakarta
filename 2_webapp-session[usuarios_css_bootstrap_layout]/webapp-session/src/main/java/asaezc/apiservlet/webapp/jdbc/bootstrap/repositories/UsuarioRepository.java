package asaezc.apiservlet.webapp.jdbc.bootstrap.repositories;

import asaezc.apiservlet.webapp.jdbc.bootstrap.models.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioRepository extends Repository<Usuario> {
    Usuario porUsername(String username) throws SQLException;

}