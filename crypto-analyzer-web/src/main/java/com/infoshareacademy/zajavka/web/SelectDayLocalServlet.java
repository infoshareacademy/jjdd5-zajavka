package com.infoshareacademy.zajavka.web;

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
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/select-day-local")
public class SelectDayLocalServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    private static final Logger LOG = LoggerFactory.getLogger(SelectDayServlet.class);
    private static final String TEMPLATE_NAME = "selectDayLocal";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");

        Map<String, Object> model = new HashMap<>();

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        model.put("endDate", endDate);
        model.put("startDate", startDate);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error while processing the template: " + e);
        }
    }
}