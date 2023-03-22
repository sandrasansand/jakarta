package org.asaezc.apiservlet.webapp.headers.services;

import org.asaezc.apiservlet.webapp.headers.models.Producto;

import java.util.Arrays;
import java.util.List;

public class ProductoServiceImpl implements ProductoService{
    @Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1L, "notebook", "informatica", 175000),
                new Producto(2L, "mesa escritorio", "oficina", 150),
                new Producto(3L, "teclado", "informatica", 125));
    }
}
