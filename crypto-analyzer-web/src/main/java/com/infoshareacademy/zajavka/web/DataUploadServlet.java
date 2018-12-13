package com.infoshareacademy.zajavka.web;

import com.infoshareacademy.zajavka.freemarker.TemplateProvider;
import com.infoshareacademy.zajavka.service.UnzipService;
import com.infoshareacademy.zajavka.service.UploadService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"/data-upload"})
@MultipartConfig(fileSizeThreshold = UploadService.MEMORY_THRESHOLD,
        maxFileSize = UploadService.MAX_FILE_SIZE,
        maxRequestSize = UploadService.MAX_REQUEST_SIZE)
public class DataUploadServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(DataUploadServlet.class);
    private static final String TEMPLATE_NAME = "dataUpload";
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private UploadService uploadService;
    @Inject
    private UnzipService unzipService;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, Object> model = new HashMap<>();

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error while processing the template: " + e);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        Map<String, Object> model = new HashMap<>();

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error while processing the template: " + e);
        }

        String uploadedFile = uploadService.readFileFromRequest(req);
        if (uploadedFile == null) {
            resp.getWriter().println("File upload failed");

        } else {
            String extractedPath = UnzipService.EXTRACTED_DATA_PATH;
            unzipService.unzip(uploadedFile, extractedPath);
            resp.getWriter().println();
//            "Extracted to " + extractedPath
        }
    }
}
