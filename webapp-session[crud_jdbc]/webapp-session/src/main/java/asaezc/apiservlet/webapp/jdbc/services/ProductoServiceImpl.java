package asaezc.apiservlet.webapp.jdbc.services;

import asaezc.apiservlet.webapp.jdbc.models.Categoria;
import asaezc.apiservlet.webapp.jdbc.models.Producto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductoServiceImpl implements ProductoService{
    @Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1L, "notebook", "informatica", 1750),
                new Producto(2L, "mesa escritorio", "oficina", 100),
                new Producto(3L, "teclado", "informatica", 40));
    }

    @Override
    public Optional<Producto> porId(Long id) {
        return listar().stream().filter(p -> p.getId().equals(id)).findAny();
    }

    @Override
    public void guardar(Producto producto) {

    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public List<Categoria> listarCategoria() {
        return null;
    }

    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        return Optional.empty();
    }
}
