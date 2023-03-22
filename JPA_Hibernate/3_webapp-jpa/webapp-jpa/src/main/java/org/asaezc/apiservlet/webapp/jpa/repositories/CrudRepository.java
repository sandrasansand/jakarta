package org.asaezc.apiservlet.webapp.jpa.repositories;

import java.util.List;

public interface CrudRepository<T> {
    //SQLexception -> Exception -> Jpa
    List<T> listar() throws Exception;
    T porId(Long id) throws Exception;
    void guardar(T t) throws Exception;
    void eliminar(Long id) throws Exception;
}
