package com.infoshareacademy.zajavka.web;

import com.infoshareacademy.zajavka.data.ListDirectoryException;
import com.infoshareacademy.zajavka.freemarker.TemplateProvider;
import com.infoshareacademy.zajavka.service.LoginService;
import com.infoshareacademy.zajavka.service.ReadFilesToBase;
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
import java.util.List;
import java.util.Map;

@WebServlet("/test2")
public class LoadFileToBaseSerwlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(DataUploadServlet.class);

    private static final String TEMPLATE_NAME = "loadFile";

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private ReadFilesToBase readFilesToBase;

    @Inject
    private LoginService loginService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> model = new HashMap<>();

        loginService.addUserNameToSesionIfLogin(req, model);

        try {
            List<String> names = readFilesToBase.getFileNames();
            model.put("Currency", names);
            readFilesToBase.readFilesAndSaveInBase(names);
        } catch (ListDirectoryException e) {
            LOG.error("Error readFilesToBase.getFileNames(): " + e);
        }


        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("template.process(model, resp.getWriter()): " + e);
        }
    }
}
