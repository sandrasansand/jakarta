package org.asaezc.apiservlet.webapp.listeners.filters.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.asaezc.apiservlet.webapp.listeners.filters.models.Carro;
import org.asaezc.apiservlet.webapp.listeners.filters.models.ItemCarro;
import org.asaezc.apiservlet.webapp.listeners.filters.models.Producto;
import org.asaezc.apiservlet.webapp.listeners.filters.services.ProductoService;
import org.asaezc.apiservlet.webapp.listeners.filters.services.ProductoServiceImpl;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/carro/agregar")
public class AgregarCarroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        ProductoService service = new ProductoServiceImpl();
        Optional<Producto> producto = service.porId(id);
        if (producto.isPresent()) {
            ItemCarro item = new ItemCarro(1, producto.get());
            HttpSession session = req.getSession();
            Carro carro = (Carro) session.getAttribute("carro");
            carro.addItemCarro(item);
        }
        resp.sendRedirect(req.getContextPath() + "/carro/ver");
    }
}
