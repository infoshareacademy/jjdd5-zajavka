package com.infoshareacademy.zajavka.web;

import com.infoshareacademy.zajavka.freemarker.TemplateProvider;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;



@WebServlet(urlPatterns = {"/data-upload"})

@MultipartConfig (fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 *5, maxRequestSize = 1024 * 1024 * 5* 5)

public class DataUploadServlet extends HttpServlet {

    @Inject
    TemplateProvider templateProvider;

    private static final Logger LOG = LoggerFactory.getLogger(DataUploadServlet.class);
    private static final String TEMPLATE_NAME = "dataUpload";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);
    }
}
