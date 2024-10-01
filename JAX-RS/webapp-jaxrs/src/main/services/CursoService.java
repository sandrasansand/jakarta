package org.asaez.webapp.jaxws.services;
import jakarta.ejb.Local;
import org.asaez.webapp.jaxws.models.Curso;
import java.util.List;
import java.util.Optional;
//no necesario
@Local
public interface CursoService {
    List<Curso> listar();
    Curso guardar(Curso curso);
    Optional<Curso> porId(Long id);
    void eliminar(Long id);
}
