package com.infoshareacademy.zajavka.service;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Stateless
public class LoginService {

    private static final String SESSION_ATTRIBUTE_NAME = "userName";

    public static Map<String, Object> addUserNameToSesionIfLogin(HttpServletRequest req, Map<String, Object> modelIn){

        Map<String, Object> model = modelIn;

        HttpSession session = req.getSession();
        String sessionName = (String) session.getAttribute(SESSION_ATTRIBUTE_NAME);
        if(sessionName!=null) {
            model.put("sessionName", sessionName);
        }
        return model;
    }
}
