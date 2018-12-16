package com.infoshareacademy.zajavka.web;

import com.infoshareacademy.zajavka.dao.ConfigurationDao;
import com.infoshareacademy.zajavka.dao.DailyDataDao;
import com.infoshareacademy.zajavka.data.Currency;
import com.infoshareacademy.zajavka.data.DailyData;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/current")
public class CurrentValueServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(CurrentValueServlet.class);
    private static final String TEMPLATE_NAME = "currentValue";

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private DailyDataDao dailyDataDao;

    @Inject
    private ConfigurationDao configurationDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       // String dtf = configurationDao.findValue("dateFormat");
        String dtf = "dd-MM-yyyy";

        //String numberAfterSign = configurationDao.findValue("afterSign");
        // Integer numberAfterInt = Integer.valueOf(numberAfterSign);

        HttpSession session = req.getSession();
        String chosenCurrency;
      /*  Map<String, Object> modelDate = new HashMap<>();
        Map<String, Object> modelPrice = new HashMap<>();*/
        Map<String, Object> model = new HashMap<>();
        String currency = (String) session.getAttribute("currency");
        if (currency == null || currency.isEmpty()) {
            chosenCurrency = "No chosen currency";
        } else {
            LocalDate dailyDataDate = LocalDate.parse(dailyDataDao.getMostActualDataForCurrency(currency).getDate().toString());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dtf);
           // LocalDate date = formatter.format(dailyDataDate);
            //    LocalDate dateFormat = dailyDataDate.format();
//                    dtf.parse(dailyDataDate);
           // DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dtf);
            //LocalDate date = dailyDataDate.format();
            //LocalDate aaa = dailyDataDate.format(DateTimeFormatter.ofPattern(formatter));

            model.put("DailyDataDate", formatter.format(dailyDataDate));
           // model.put("DailyDataDate", formatter.format(dailyDataDate));
//            modelPrice.put("DailyDataPrice", dailyDataDao.getMostActualDataForCurrency(currency).getPriceUSD().setScale(numberAfterInt));
           // model.put("DailyDataPrice", dailyDataDao.getMostActualDataForCurrency(currency).getPriceUSD());
           model.put("DailyDataPrice", dailyDataDao.getMostActualDataForCurrency(currency).getPriceUSD());
            chosenCurrency = "Actual currency: " + currency;
        }

        model.put("chosenCurrency", chosenCurrency);

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        try {
            template.process(model, resp.getWriter());
           /* template.process(modelPrice, resp.getWriter());
            template.process(modelDate, resp.getWriter());*/
        } catch (TemplateException e) {
            LOG.error("Error while processing the template: " + e);
        }

    }
}
