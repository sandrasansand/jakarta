package org.asaezc.java.jdbc;

import org.asaezc.java.jdbc.modelo.Producto;
import org.asaezc.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.asaezc.java.jdbc.repositorio.Repositorio;

public class EjemploJdbcDelete {
    public static void main(String[] args) {

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("============= listar =============");
            repositorio.listar().forEach(System.out::println);

            System.out.println("============= obtener por id =============");
            System.out.println(repositorio.porId(13L));

            System.out.println("============= Eliminar producto =============");
            repositorio.eliminar(13L);
            System.out.println("Producto eliminado con éxito");
            repositorio.listar().forEach(System.out::println);

    }
}
