package com.infoshareacademy.zajavka.dao;

import com.infoshareacademy.zajavka.data.CurrencyName;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Stateless
public class CurrencyNameDao {

    @PersistenceContext
    private EntityManager entityManager;

    public String save(CurrencyName s) {
        entityManager.persist(s);
        return s.getNameFile();
    }
    public CurrencyName update(CurrencyName s) {
        return entityManager.merge(s);
    }

    public void delete(Long id) {
        final CurrencyName s = entityManager.find(CurrencyName.class, id);
        if (s != null) {
            entityManager.remove(s);
        }
    }

    public CurrencyName findById(Long id) {
        return entityManager.find(CurrencyName.class, id);
    }

    public List<CurrencyName> findAll() {
        final Query query = entityManager.createQuery("SELECT s FROM CurrencyName s");

        return query.getResultList();
    }
    public Map<String ,String> findAllMap() {
        final Query query = entityManager.createQuery("SELECT s FROM CurrencyName s");
        List<CurrencyName> currency = query.getResultList();
       return currency.stream().collect(Collectors.toMap(CurrencyName :: getNameFile, CurrencyName::getNameCurrency));

    }


}
