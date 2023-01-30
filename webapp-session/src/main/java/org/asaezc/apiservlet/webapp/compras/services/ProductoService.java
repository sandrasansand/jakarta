package org.asaezc.apiservlet.webapp.compras.services;

import org.asaezc.apiservlet.webapp.compras.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listar();
    Optional<Producto> porId(Long id);
}
