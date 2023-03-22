package org.asaezc.apiservlet.webapp.listeners.filters.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.asaezc.apiservlet.webapp.listeners.filters.services.LoginService;
import org.asaezc.apiservlet.webapp.listeners.filters.services.LoginServiceSessionImpl;

import java.io.IOException;
import java.util.Optional;

@WebFilter({"/carro/*"})
public class LoginFiltro implements Filter {
    //antes del req se inicializa el doFilter(), indicamos en que filter @WebFilter
    //todo *carro es private se aplica a cualquier ruta que comience con carro
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LoginService service = new LoginServiceSessionImpl();
        Optional<String> username = service.getUsername((HttpServletRequest) request);
        if (username.isPresent()) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse)response).sendError(HttpServletResponse.SC_UNAUTHORIZED,
                    "Lo sentimos no estas autorizado para entrar en esta pagina!");
        }
    }
}
