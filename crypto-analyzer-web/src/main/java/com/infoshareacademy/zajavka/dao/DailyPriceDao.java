/*
package com.infoshareacademy.zajavka.dao;

import com.infoshareacademy.zajavka.domain.DailyPrice;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class DailyPriceDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Long save(DailyPrice s) {
        entityManager.persist(s);
        return s.getId();
    }

    public DailyPrice update(DailyPrice s) {
        return entityManager.merge(s);
    }

    public void delete(String id) {
        final DailyPrice s = entityManager.find(DailyPrice.class, id);
        if (s != null) {
            entityManager.remove(s);
        }
    }

    public DailyPrice findById(String id) {
        return entityManager.find(DailyPrice.class, id);
    }

    public List<DailyPrice> findAll() {
        final Query query = entityManager.createQuery("SELECT s FROM DailyPrice s");

        return query.getResultList();
    }
}


*/
