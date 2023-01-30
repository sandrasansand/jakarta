package org.asaezc.apiservlet.webapp.session.services;

import org.asaezc.apiservlet.webapp.session.models.Producto;

import java.util.Arrays;
import java.util.List;

public class ProductoServiceImpl implements ProductoService{
    @Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1L, "ordenador", "informatica", 1250),
                new Producto(2L, "mesa escritorio", "oficina", 250),
                new Producto(3L, "teclado", "informatica", 45));
    }
}
