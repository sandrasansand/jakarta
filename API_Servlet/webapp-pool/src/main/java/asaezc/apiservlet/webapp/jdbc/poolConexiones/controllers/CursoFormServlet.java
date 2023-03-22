package asaezc.apiservlet.webapp.jdbc.poolConexiones.controllers;

import asaezc.apiservlet.webapp.jdbc.poolConexiones.services.CursoService;
import asaezc.apiservlet.webapp.jdbc.poolConexiones.services.CursoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import asaezc.apiservlet.webapp.jdbc.poolConexiones.models.Curso;

@WebServlet("/cursos/form")
public class CursoFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        CursoService service = new CursoServiceImpl(conn);
        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e) {
            id = 0L;
        }
        Curso curso = new Curso();
        if (id > 0) {
            Optional<Curso> o = service.porId(id);
            if (o.isPresent()) {
                curso = o.get();
            }
        }
        req.setAttribute("curso", curso);
        req.setAttribute("titulo", id > 0 ? "Tarea: Editar curso" : "Tarea 10: Crear curso");
        getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection conn = (Connection) req.getAttribute("conn");
        CursoService service = new CursoServiceImpl(conn);
        String nombre = req.getParameter("nombre");
        String descripcion = req.getParameter("descripcion");
        String profesor = req.getParameter("profesor");

        double duracion;
        try {
            duracion = Double.parseDouble(req.getParameter("duracion"));
        } catch (NumberFormatException e) {
            duracion = 0;
        }

        Map<String, String> errores = new HashMap<>();
        if (nombre == null || nombre.isBlank()) {
            errores.put("nombre", "el nombre es requerido!");
        }
        if (descripcion == null || descripcion.isBlank()) {
            errores.put("descripcion", "la descripcion es requerida!");
        }

        if (profesor == null || profesor.isBlank()) {
            errores.put("profesor", "el profesor es requerido");
        }
        if (duracion == 0) {
            errores.put("duracion", "la duracion es requerida!");
        }

        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e) {
            id = 0L;
        }
        Curso curso = new Curso();
        curso.setId(id);
        curso.setNombre(nombre);
        curso.setDescripcion(descripcion);
        curso.setProfesor(profesor);
        curso.setDuracion(duracion);

        if (errores.isEmpty()) {
            service.guardar(curso);
            resp.sendRedirect(req.getContextPath() + "/cursos");
        } else {
            req.setAttribute("errores", errores);
            req.setAttribute("curso", curso);
            req.setAttribute("titulo", id > 0 ? "Tarea: Editar curso" : "Tarea 10: Crear curso");
            getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);
        }
    }
}
