package org.asaezc.java.jdbc.pool.trx;

import org.asaezc.java.jdbc.pool.trx.modelo.Categoria;
import org.asaezc.java.jdbc.pool.trx.modelo.Producto;
import org.asaezc.java.jdbc.pool.trx.repositorio.CategoriaRepositorioImpl;
import org.asaezc.java.jdbc.pool.trx.repositorio.ProductoRepositorioImpl;
import org.asaezc.java.jdbc.pool.trx.repositorio.Repositorio;
import org.asaezc.java.jdbc.pool.trx.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) throws SQLException {
            try(Connection conn = ConexionBaseDatos.getConnection()) {
                    if (conn.getAutoCommit()) {
                            conn.setAutoCommit(false);
                    }
                    try {
                            Repositorio<Categoria> repositorioCategoria = new CategoriaRepositorioImpl(conn);
                            System.out.println("============= Insertar nueva categoria =============");
                            Categoria categoria = new Categoria();
                            categoria.setNombre("Electrohogar");
                            Categoria nuevaCategoria = repositorioCategoria.guardar(categoria);
                            System.out.println("Categoria guardada con éxito: " + nuevaCategoria.getId());

                            Repositorio<Producto> repositorio = new ProductoRepositorioImpl(conn);
                            System.out.println("============= listar =============");
                            repositorio.listar().forEach(System.out::println);

                            System.out.println("============= obtener por id =============");
                            System.out.println(repositorio.porId(1L));

                            System.out.println("============= insertar nuevo producto =============");
                            Producto producto = new Producto();
                            producto.setNombre("Refrigerador Samsung");
                            producto.setPrecio(1200);
                            producto.setFechaRegistro(new Date());
                            producto.setSku("abcdefg123");

                            producto.setCategoria(nuevaCategoria);
                            repositorio.guardar(producto);
                            System.out.println("Producto guardado con éxito: " + producto.getId());
                            repositorio.listar().forEach(System.out::println);

                            conn.commit();
                    } catch (SQLException e) {
                            conn.rollback();
                            e.printStackTrace();
                    }
            }
    }
}
