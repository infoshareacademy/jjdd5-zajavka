package com.infoshareacademy.zajavka.web;

import com.infoshareacademy.zajavka.dao.ConfigurationDao;
import com.infoshareacademy.zajavka.data.Configuration;
import com.infoshareacademy.zajavka.freemarker.TemplateProvider;
import com.infoshareacademy.zajavka.service.ConfigurationService;
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

        Map<String, Object> config = new HashMap<>();
        config.put("dateFormat", configurationDao.findValue("dateFormat"));
        config.put("afterSign", configurationDao.findValue("afterSign"));

        try {
            template.process(config, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error while processing the template: " + e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String action = req.getParameter("action");
        LOG.info("Requested action: {}", action);
        if (action == null || action.isEmpty()) {
            resp.getWriter().write("Empty action parameter.");
            return;
        }
        if (action.equals("update")) {
            update(req, resp);
        } else {
            resp.getWriter().write("Unknown action.");
        }
        doGet(req, resp);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        final String nameConfiguration = req.getParameter("nameConfig");
        LOG.info("Updating configuration with name = {}", nameConfiguration);

        final Configuration existingConfiguration = configurationDao.findById(nameConfiguration);
        if (existingConfiguration == null) {
            LOG.info("No configuration found for name = {}, nothing to be updated", nameConfiguration);
        } else {
            existingConfiguration.setValue(req.getParameter("value"));

            configurationDao.update(existingConfiguration);

            LOG.info("Configuration updated: {}", existingConfiguration);
        }

    }
}
