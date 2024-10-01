package org.asaezc.webapp.jaxws.services;
import jakarta.jws.WebService;
import org.asaezc.webapp.jaxws.models.Curso;
import java.util.List;

@WebService
public interface ServicioWs {
    String saludar(String persona);
    List<Curso> listar();
    Curso crear(Curso curso);
}

