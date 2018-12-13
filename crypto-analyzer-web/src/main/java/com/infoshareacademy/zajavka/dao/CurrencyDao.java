package com.infoshareacademy.zajavka.dao;

import com.infoshareacademy.zajavka.data.Currency;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class CurrencyDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Currency s) {
        entityManager.persist(s);
    }

    public Currency update(Currency s) {
        return entityManager.merge(s);
    }


    public Currency findByName(String name) {
        return entityManager.find(Currency.class, name);
    }


    public List<Currency> findAll() {
        final Query query = entityManager.createQuery("SELECT s FROM Currency s");

        return query.getResultList();
    }
}
