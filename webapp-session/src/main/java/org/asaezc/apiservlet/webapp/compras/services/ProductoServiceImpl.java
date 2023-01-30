package org.asaezc.apiservlet.webapp.compras.services;

import org.asaezc.apiservlet.webapp.compras.models.Producto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductoServiceImpl implements ProductoService{
    @Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1L, "ordenador", "informatica", 1750),
                new Producto(2L, "mesa escritorio", "oficina", 100),
                new Producto(3L, "teclado", "informatica", 40));
    }

    @Override
    public Optional<Producto> porId(Long id) {

        return listar().stream().filter(p -> p.getId().equals(id)).findAny();
    }
}
