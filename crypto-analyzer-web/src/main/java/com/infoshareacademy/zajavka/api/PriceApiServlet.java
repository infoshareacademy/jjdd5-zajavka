package com.infoshareacademy.zajavka.api;


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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;



@WebServlet("/api-demo")
public class PriceApiServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    PriceClientImpl priceClient;

    private static final Logger LOG = LoggerFactory.getLogger(PriceApiServlet.class);
    private static final String TEMPLATE_NAME = "apiDemo";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> model = new HashMap<>();

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        PriceResponse btc = priceClient.getPriceForBtc();
        PriceResponse eth = priceClient.getPriceForEth();
        PriceResponse ltc = priceClient.getPriceForLtc();

        model.put("btc",btc);
        model.put("ltc",ltc);
        model.put("eth",eth);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error while processing the template: " + e);
        }

    }
}