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

    public void delete(String name){
        final Configuration c = entityManager.find(Configuration.class, name);
        if(c != null){
            entityManager.remove(c);
        }
    }

    public Configuration findById(String name) {
        return entityManager.find(Configuration.class, name);
    }

    public String findValue(String name) {
        final Query query = entityManager.createQuery("SELECT c.value FROM Configuration c WHERE c.name = :name");
        query.setParameter("name", name);
        return (String) query.getSingleResult();
    }

    public List<Configuration> findAll(){
        final Query query = entityManager.createQuery("SELECT c FROM Configuration c");

        return query.getResultList();
    }

}
