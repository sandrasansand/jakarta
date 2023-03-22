package org.asaezc.apiservlet.webapp.jpa.repositories;

import org.asaezc.apiservlet.webapp.jpa.models.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario> {
    Usuario porUsername(String username) throws Exception;
}
