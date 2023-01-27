package org.asaezc.apiservlet.webapp.headers.controllers;
/*listamos con get y mostramos con post, consumimos la api rest en postman
para comprobar el envío de datos del servlet*/
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.asaezc.apiservlet.webapp.headers.models.Producto;
import org.asaezc.apiservlet.webapp.headers.services.ProductoService;
import org.asaezc.apiservlet.webapp.headers.services.ProductoServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/productos.json")
public class ProductoJsonServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //recibimos el obj json como parametro de entrada
        ServletInputStream jsonStream = req.getInputStream();
        //convertimos el json de tipo stream a un tipo obj producto
        ObjectMapper mapper = new ObjectMapper();
        Producto producto = mapper.readValue(jsonStream, Producto.class);
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <meta charset=\"UTF-8\">");
            out.println("        <title>Detalle de producto desde json</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("        <h1>Detalle de producto desde json!</h1>");
            out.println("<ul>");
            out.println("<li>Id: "+ producto.getId() + "</li>");
            out.println("<li>Nombre: " + producto.getNombre() + "</li>");
            out.println("<li>Tipo: " + producto.getTipo() + "</li>");
            out.println("<li>Precio: " + producto.getPrecio() + "</li>");
            out.println("</ul>");
            out.println("    </body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductoService service = new ProductoServiceImpl();
        List<Producto> productos = service.listar();
        //clase de la dependencia json jackson del maven para exportar a este formato
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(productos);
        resp.setContentType("application/json");
        resp.getWriter().write(json);
    }
}
