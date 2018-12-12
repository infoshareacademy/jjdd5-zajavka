package com.infoshareacademy.zajavka.web;

import com.infoshareacademy.zajavka.data.ListDirectoryException;
import com.infoshareacademy.zajavka.freemarker.TemplateProvider;
import com.infoshareacademy.zajavka.service.ReadFilesToBase;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jdk.nashorn.internal.runtime.regexp.joni.WarnCallback;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/test2")
public class SerwletT2 extends HttpServlet {

    private static final String TEMPLATE_NAME = "loadFile";

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private ReadFilesToBase readFilesToBase;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> model = new HashMap<>();

        try {
            List<String> names = readFilesToBase.GetFileNames();
            readFilesToBase.ReadFilesAndSaveInBase(names);
        } catch (ListDirectoryException e) {
            e.printStackTrace();
        }


        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
