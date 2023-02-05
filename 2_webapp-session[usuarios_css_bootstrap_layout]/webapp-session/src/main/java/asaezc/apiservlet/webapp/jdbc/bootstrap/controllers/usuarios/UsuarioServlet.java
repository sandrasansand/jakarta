package asaezc.apiservlet.webapp.jdbc.bootstrap.controllers.usuarios;

import asaezc.apiservlet.webapp.jdbc.bootstrap.models.Usuario;

import asaezc.apiservlet.webapp.jdbc.bootstrap.services.LoginService;
import asaezc.apiservlet.webapp.jdbc.bootstrap.services.LoginServiceSessionImpl;

import asaezc.apiservlet.webapp.jdbc.bootstrap.services.UsuarioService;
import asaezc.apiservlet.webapp.jdbc.bootstrap.services.UsuarioServiceImpl;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

    @WebServlet("/usuarios")
    public class UsuarioServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Connection conn = (Connection) req.getAttribute("conn");
            UsuarioService service = new UsuarioServiceImpl(conn);
            List<Usuario> usuarios = service.listar();

            LoginService auth = new LoginServiceSessionImpl();
            Optional<String> usernameOptional = auth.getUsername(req);

            req.setAttribute("usuarios", usuarios);
            req.setAttribute("username", usernameOptional);

            req.setAttribute("title", req.getAttribute("title") + ": Listado de usuarios");
            getServletContext().getRequestDispatcher("/usuarios/listar.jsp").forward(req, resp);
        }
    }

