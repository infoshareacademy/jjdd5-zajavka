package com.infoshareacademy.zajavka.web;

import com.infoshareacademy.zajavka.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/wrong")
public class ErrorServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(ErrorServlet.class);
    private static final String TEMPLATE_NAME = "wrong";

    @Inject
    TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        Map<String, Object> model = new HashMap<>();

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        LOG.error("Error: " +  resp.getStatus() + " occured.");

        Throwable exception = (Throwable) req.getAttribute("javax.servlet.error.exception");
        if (exception != null) {
            try {
                exception = ExceptionUtils.getRootCause(exception);
                template.process(model, resp.getWriter());
                LOG.error("Error caught", exception);
            } catch (TemplateException e) {
                LOG.error("Error while processing the template: " + e);
            }

        } else {
            writer.println(" ");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}