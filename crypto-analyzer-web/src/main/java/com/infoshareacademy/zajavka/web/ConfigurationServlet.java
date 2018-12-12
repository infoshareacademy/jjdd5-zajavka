package com.infoshareacademy.zajavka.web;

import com.infoshareacademy.zajavka.dao.ConfigurationDao;
import com.infoshareacademy.zajavka.data.Configuration;
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
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/configuration")
@Transactional
public class ConfigurationServlet extends HttpServlet {

    private Logger LOG = LoggerFactory.getLogger(ConfigurationServlet.class);

    private static final String TEMPLATE_NAME = "configuration";

    @Inject
    private ConfigurationDao configurationDao;

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        /*final List<Configuration> result = configurationDao.findAll();
        LOG.info("Found {} objects", result.size());
        for (Configuration c : result) {
            resp.getWriter().write(c.toString() + "\n");
        }*/

        Map<String, Object> config = new HashMap<>();
        config.put("dateFormat", configurationDao.findValue("dataFormat"));
        config.put("afterSign", configurationDao.findValue("afterSign"));

        try {
            template.process(config, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error while processing the template: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
