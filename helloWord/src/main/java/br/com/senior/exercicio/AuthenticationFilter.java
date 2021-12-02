package br.com.senior.exercicio;

import br.com.senior.exercicio.DTO.HelloWordDTO;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static br.com.senior.exercicio.controller.ListaToken.tokens;

@Component
@Order(1)
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String authorization = request.getHeader("authorization");

        String method = ((HttpServletRequest) servletRequest).getMethod();

        if (request.getRequestURI().equals("/login")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (tokens.contains(authorization)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token Inválido");
        }

    }
}
