package asaezc.apiservlet.webapp.jdbc.poolConexiones.repositories;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {

    List<T> listar() throws SQLException;

    List<T> porNombre(String nombre) throws SQLException;

    T porId(Long id) throws SQLException;

    void guardar(T t) throws SQLException;

    void eliminar(Long id) throws SQLException;
}
