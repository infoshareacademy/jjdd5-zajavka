package com.infoshareacademy.zajavka.filters;

import com.infoshareacademy.zajavka.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(
        urlPatterns = {"/configuration", "/data-upload"}
)
public class AuthenticationAdminFilter implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationAdminFilter.class);
    private static final Integer ADMIN = 1;

    @Inject
    private UserDao userDao;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();

        if (session.getAttribute("userEmail") == null || userDao.findByEmail(session.getAttribute("userEmail").toString())==null || userDao.findByEmail(session.getAttribute("userEmail").toString()).getUserRole().intValue() != ADMIN) {
            LOG.warn("Not authorized try get acces to Admin function" );
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login");
            requestDispatcher.forward(req, resp);
        }

        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}

