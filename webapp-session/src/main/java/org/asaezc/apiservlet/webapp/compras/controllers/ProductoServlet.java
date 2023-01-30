package org.asaezc.apiservlet.webapp.compras.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.asaezc.apiservlet.webapp.compras.models.Producto;
import org.asaezc.apiservlet.webapp.compras.services.*;
import org.asaezc.apiservlet.webapp.compras.services.LoginService;
import org.asaezc.apiservlet.webapp.compras.services.LoginServiceSessionImpl;
import org.asaezc.apiservlet.webapp.compras.services.ProductoService;
import org.asaezc.apiservlet.webapp.compras.services.ProductoServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet({"/productos.html", "/productos"})
public class ProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService service = new ProductoServiceImpl();
        List<Producto> productos = service.listar();

        LoginService auth = new LoginServiceSessionImpl();
        Optional<String> usernameOptional = auth.getUsername(req);

        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <meta charset=\"UTF-8\">");
            out.println("        <title>Listado de Productos</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("        <h1>Listado de Productos!</h1>");
            if(usernameOptional.isPresent()) {
                out.println("<div style='color: blue;'>Hola " + usernameOptional.get() + " Bienvenido!</div>");
            }
                out.println("<table>");
            out.println("<tr>");
            out.println("<th>id</th>");
            out.println("<th>nombre</th>");
            out.println("<th>tipo</th>");
            if(usernameOptional.isPresent()) {
                out.println("<th>precio</th>");
                out.println("<th>agregar</th>");
            }
            out.println("</tr>");
            productos.forEach(p -> {
                out.println("<tr>");
                out.println("<td>" + p.getId() + "</td>");
                out.println("<td>" + p.getNombre() + "</td>");
                out.println("<td>" + p.getTipo() + "</td>");
                if(usernameOptional.isPresent()) {
                    out.println("<td>" + p.getPrecio() + "</td>");
                    out.println("<td><a href=\""
                            + req.getContextPath()
                            + "/agregar-carro?id=" + p.getId()
                            + "\">agregar al carro</a></td>");
                }
                out.println("</tr>");
            });
            out.println("</table>");
            out.println("    </body>");
            out.println("</html>");
        }
    }
}
