package com.infoshareacademy.zajavka.web;

import com.infoshareacademy.zajavka.dao.CurrencyNameDao;
import com.infoshareacademy.zajavka.freemarker.TemplateProvider;
import freemarker.template.Template;
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

@WebServlet(urlPatterns = "/editCurrencyName")
@Transactional
public class EditCurrencyNameServlet extends HttpServlet {

    private Logger LOG = LoggerFactory.getLogger(EditCurrencyNameServlet.class);

    private static final String TEMPLATE_NAME = "editCurrencyName";

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private CurrencyNameDao currencyNameDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        String param = req.getParameter("edit");

        Map<String, Object> config = new HashMap<>();
        config.put("dateFormat", currencyNameDao.findValue("dateFormat"));

    }
}
