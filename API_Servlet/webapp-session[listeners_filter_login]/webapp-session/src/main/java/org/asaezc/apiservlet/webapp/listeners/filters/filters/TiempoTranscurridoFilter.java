package org.asaezc.apiservlet.webapp.listeners.filters.filters;

import jakarta.servlet.*;
import java.io.IOException;
import jakarta.servlet.annotation.WebFilter;
import java.util.logging.Logger;

@WebFilter("/*")
public class TiempoTranscurridoFilter implements Filter {

    private static final Logger logger =  Logger.getLogger("TiempoTranscurridoFilter");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        long inicio = System.currentTimeMillis();
        chain.doFilter(request, response);
        long fin = System.currentTimeMillis();
        long resultado = fin - inicio;

        // imprimimos en el logs o imprimir directamente en consola con System.out.println
        logger.info(String.format("El tiempo de carga de la página es de %s milisegundos", resultado));

    }
}