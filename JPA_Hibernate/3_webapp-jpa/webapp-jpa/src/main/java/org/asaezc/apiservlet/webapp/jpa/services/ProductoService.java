package org.asaezc.apiservlet.webapp.jpa.services;

import org.asaezc.apiservlet.webapp.jpa.models.entities.Categoria;
import org.asaezc.apiservlet.webapp.jpa.models.entities.Producto;

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
