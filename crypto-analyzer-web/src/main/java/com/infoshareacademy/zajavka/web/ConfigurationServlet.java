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
import java.time.LocalDateTime;
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


 /*       Map<String, Object> model = new HashMap<>();
        model.put("date", LocalDateTime.now());
        model.put("grup", "jjdd5-zajavka");
        model.put("student", "Bartosz Wisniewski");

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }*/
        Map<String, Object> model = new HashMap<>();

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error while processing the template: " + e);
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


     /*   Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

            final String name = req.getParameter("name");
            LOG.info("Updating Computer with id = {}", name);

            final Configuration existingConfiguration = configurationDao.findByName(name);
            if (existingConfiguration == null) {
                LOG.info("No Computer found for id = {}, nothing to be updated", name);
            } else {
                existingConfiguration.setName(req.getParameter("name"));
                existingConfiguration.setValue(req.getParameter("value"));

                configurationDao.update(existingConfiguration);
                LOG.info("Computer object updated: {}", existingConfiguration);
            }
*/
            // Return all persisted objects
            //findAll(req, resp);
        }

    private void update(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        final String name = req.getParameter("name");
        LOG.info("Updating Computer with id = {}", name);

        final Configuration existingConfiguration = configurationDao.findByName(name);
        if (existingConfiguration == null) {
            LOG.info("No Computer found for id = {}, nothing to be updated", name);
        } else {
            existingConfiguration.setName(req.getParameter("name"));
            existingConfiguration.setValue(req.getParameter("value"));

            configurationDao.update(existingConfiguration);
            LOG.info("Computer object updated: {}", existingConfiguration);
        }

        // Return all persisted objects
        //findAll(req, resp);
    }
    }

