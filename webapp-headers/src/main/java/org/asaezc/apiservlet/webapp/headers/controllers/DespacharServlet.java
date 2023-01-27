package org.asaezc.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/despachar")
public class DespacharServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //modifica el recurso no es un redirect, dentro del request carga otra jsp u otro servlet
        //une la petición actual a otra, no cambia la ruta. Se une a la url el nuevo request
        getServletContext().getRequestDispatcher("/productos.html").forward(req, resp);
    }
}
