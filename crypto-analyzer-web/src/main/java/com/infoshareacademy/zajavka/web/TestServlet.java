package com.infoshareacademy.zajavka.web;

import com.infoshareacademy.zajavka.dao.ConfigurationDao;
import com.infoshareacademy.zajavka.data.Configuration;
import com.infoshareacademy.zajavka.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/test")
public class TestServlet extends HttpServlet {

    private static final String TEMPLATE_NAME = "test";

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private ConfigurationDao configurationDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        Configuration c1 = new Configuration("dateFormat", "dd-MM-yyyy");
        Configuration c2 = new Configuration( "afterSign", "3");
        configurationDao.save(c1);
        configurationDao.save(c2);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> model = new HashMap<>();
        model.put("date", LocalDateTime.now());

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
