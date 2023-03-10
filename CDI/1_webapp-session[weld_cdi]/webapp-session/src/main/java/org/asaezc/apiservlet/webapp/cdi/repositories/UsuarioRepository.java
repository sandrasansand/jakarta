package org.asaezc.apiservlet.webapp.cdi.repositories;

import org.asaezc.apiservlet.webapp.cdi.models.Usuario;

import java.sql.SQLException;

public interface UsuarioRepository extends CrudRepository<Usuario> {
    Usuario porUsername(String username) throws SQLException;
}
