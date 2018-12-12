
package com.infoshareacademy.zajavka.dao;

import com.infoshareacademy.zajavka.domain.Currency;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CurrencyDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Long save(Currency s) {
        entityManager.persist(s);
        return s.getId();
    }

    public Currency update(Currency s) {
        return entityManager.merge(s);
    }

    public void delete(Long id) {
        final Currency s = entityManager.find(Currency.class, id);
        if (s != null) {
            entityManager.remove(s);
        }
    }

    public Currency findById(Long id) {
        return entityManager.find(Currency.class, id);
    }

    public List<Currency> findAll() {
        final Query query = entityManager.createQuery("SELECT s FROM Currency s");

        return query.getResultList();
    }
}

