package com.infoshareacademy.zajavka.dao;

import com.infoshareacademy.zajavka.data.Configuration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ConfigurationDao {

    @PersistenceContext
    private EntityManager entityManager;

    public String save(Configuration c){
        entityManager.persist(c);
        return c.getName();
    }

    public Configuration findByName(String name) {
        return entityManager.find(Configuration.class, name);
    }

    public Configuration update (Configuration c){
        return entityManager.merge(c);
    }

}
