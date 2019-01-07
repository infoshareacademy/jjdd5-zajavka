package com.infoshareacademy.zajavka.web.login;

import com.infoshareacademy.zajavka.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(LogoutServlet.class);
    private static final String TEMPLATE_NAME = "login";

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws  IOException {

            Map<String, Object> model = new HashMap<>();
            HttpSession session = req.getSession(true);
            session.invalidate();

            Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

            resp.sendRedirect(req.getContextPath() + "/login");

            try {
                template.process(model, resp.getWriter());
                LOG.info("Logout user");
            } catch (TemplateException e) {
                LOG.error("Failed to logout user");
            }
    }
}