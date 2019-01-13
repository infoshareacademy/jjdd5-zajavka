package com.infoshareacademy.zajavka.service;

import com.infoshareacademy.zajavka.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Stateless
public class LoginService {

    private static final Logger LOG = LoggerFactory.getLogger(LoginService.class);


    @Inject
    private UserDao userDao;

    private static final String SESSION_ATTRIBUTE_NAME = "userName";
    private static final String SESSION_ATTRIBUTE_EMAIL = "userEmail";
    private static final Integer ADMIN = 1;

    public Map<String, Object> addUserNameToSesionIfLogin(HttpServletRequest req, Map<String, Object> modelIn){

        Map<String, Object> model = modelIn;

        HttpSession session = req.getSession();
        String sessionName = (String) session.getAttribute(SESSION_ATTRIBUTE_NAME);
        String sessionEmail = (String) session.getAttribute(SESSION_ATTRIBUTE_EMAIL);
        if(sessionName!=null && sessionEmail!=null) {
            LOG.info("logged");
            model.put("sessionName", sessionName);
            if (userDao.findByEmail(sessionEmail)!=null && userDao.findByEmail(sessionEmail).getUserRole() == ADMIN) {
                LOG.info("logged as admin" );
                model.put("sessionRole", "ADMIN");
            }
        }
        return model;
    }
}
