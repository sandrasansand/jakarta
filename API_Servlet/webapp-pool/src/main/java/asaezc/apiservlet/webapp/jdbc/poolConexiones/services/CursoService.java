package asaezc.apiservlet.webapp.jdbc.poolConexiones.services;

import asaezc.apiservlet.webapp.jdbc.poolConexiones.models.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {

    List<Curso> listar();

    List<Curso> porNombre(String nombre);

    Optional<Curso> porId(Long id);

    void guardar(Curso curso);

    void eliminar(Long id);
}
