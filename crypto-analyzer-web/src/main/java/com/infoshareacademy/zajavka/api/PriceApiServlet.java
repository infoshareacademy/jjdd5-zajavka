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
    private static final String NAME_BTC = "BTC";
    private static final String NAME_LTC = "LTC";
    private static final String NAME_ETH = "ETH";
    private static final String NAME_XRP = "XRP";
    private static final String NAME_EOS = "EOS";
    private static final String NAME_TRX = "TRX";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> model = new HashMap<>();

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        String btc = priceClient.getPriceForBtc(NAME_BTC);
        String eth = priceClient.getPriceForBtc(NAME_ETH);
        String ltc = priceClient.getPriceForBtc(NAME_LTC);
        String xrp = priceClient.getPriceForBtc(NAME_XRP);
        String eos = priceClient.getPriceForBtc(NAME_EOS);
        String trx = priceClient.getPriceForBtc(NAME_TRX);

        model.put("btc",btc);
        model.put("ltc",ltc);
        model.put("eth",eth);
        model.put("xrp",xrp);
        model.put("eos",eos);
        model.put("trx",trx);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Error while processing the template: " + e);
        }

    }
}