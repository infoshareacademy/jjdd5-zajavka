package com.infoshareacademy.zajavka.api;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api-demo")
public class PriceApiServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(PriceApiServlet.class);
    private static final String TEMPLATE_NAME = "globalExtremes";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}