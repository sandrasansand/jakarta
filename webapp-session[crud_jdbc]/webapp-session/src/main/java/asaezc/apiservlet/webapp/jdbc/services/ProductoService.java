package asaezc.apiservlet.webapp.jdbc.services;

import asaezc.apiservlet.webapp.jdbc.models.Categoria;
import asaezc.apiservlet.webapp.jdbc.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listar();

    Optional<Producto> porId(Long id);

    void guardar(Producto producto);

    void eliminar(Long id);

    List<Categoria> listarCategoria();

    Optional<Categoria> porIdCategoria(Long id);
}
