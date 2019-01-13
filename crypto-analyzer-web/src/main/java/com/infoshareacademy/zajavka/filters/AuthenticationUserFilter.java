package com.infoshareacademy.zajavka.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(
        urlPatterns = {"/rateHistory", "/time-range"}
)
public class AuthenticationUserFilter implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationUserFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();

        if (session.getAttribute("userName") == null) {
            LOG.info("Redirect to /login, reason: not logged" );
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login");
            requestDispatcher.forward(req, resp);
        }

        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}

