package org.asaezc.apiservlet.webapp.listeners.filters.services;

import org.asaezc.apiservlet.webapp.listeners.filters.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listar();
    Optional<Producto> porId(Long id);
}
