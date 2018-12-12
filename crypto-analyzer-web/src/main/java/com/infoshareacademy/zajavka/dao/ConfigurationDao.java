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

    public Configuration update (Configuration c){
        return entityManager.merge(c);
    }

    public void delete(String name){
        final Configuration c = entityManager.find(Configuration.class, name);
        if(c != null){
            entityManager.remove(c);
        }
    }

    public List<Configuration> findAll(){
        final Query query = entityManager.createQuery("SELECT * FROM Configuration c");

        return query.getResultList();
    }

}
