package org.asaezc.apiservlet.webapp.compras.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.asaezc.apiservlet.webapp.compras.models.Carro;
import org.asaezc.apiservlet.webapp.compras.models.ItemCarro;
import org.asaezc.apiservlet.webapp.compras.models.Producto;
import org.asaezc.apiservlet.webapp.compras.services.ProductoService;
import org.asaezc.apiservlet.webapp.compras.services.ProductoServiceImpl;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/agregar-carro")
public class AgregarCarroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        ProductoService service = new ProductoServiceImpl();
        Optional<Producto> producto = service.porId(id);
        if (producto.isPresent()) {
            ItemCarro item = new ItemCarro(1, producto.get());
            HttpSession session = req.getSession();
            Carro carro;
            //si entramos en la web y no existe la sessión carro la creamos
            if (session.getAttribute("carro") == null) {
                carro = new Carro();
                session.setAttribute("carro", carro);
            } else {
                //por defecto si existe no entra en bucle
                //casteamos porque en sessiones se guardan como tipo Object, diferente a la cookie q es un string
                carro = (Carro) session.getAttribute("carro");
            }
            //guardamos item en carro cantidad 1 -> valor
            carro.addItemCarro(item);
        }
        // redirigimos
        resp.sendRedirect(req.getContextPath() + "/ver-carro");
    }
}
