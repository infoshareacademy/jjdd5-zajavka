package com.infoshareacademy.zajavka.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(
        urlPatterns = {"/rateHistory", "/select-time-range"}
        )
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();

        if (session.getAttribute("userName") == null) {
            RequestDispatcher requestDispatcher =req.getRequestDispatcher("/login");
            requestDispatcher.forward(req, resp);
        }

        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}

