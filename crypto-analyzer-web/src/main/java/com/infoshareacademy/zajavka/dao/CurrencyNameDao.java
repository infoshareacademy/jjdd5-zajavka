package com.infoshareacademy.zajavka.dao;

import com.infoshareacademy.zajavka.data.CurrencyName;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
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

 /*   public Map<String ,String> findByName(String name) {
        String fileName = entityManager.find(CurrencyName.class, name).getNameFile();
        String currencyName = entityManager.find(CurrencyName.class, name).getNameCurrency();
        return  fileName & currencyName;
    }*/

    public List<CurrencyName> findAll() {
        final Query query = entityManager.createQuery("SELECT s FROM CurrencyName s");

        return query.getResultList();
    }
    public Map<String ,String> findAllMap() {
        final Query query = entityManager.createQuery("SELECT s FROM CurrencyName s");
        List<CurrencyName> currency = query.getResultList();
       return currency.stream().collect(Collectors.toMap(CurrencyName :: getNameFile, CurrencyName::getNameCurrency));

    }

    public String findValue(String name) {
        final Query query = entityManager.createQuery("SELECT c.value FROM Configuration c WHERE c.name = :name");
        query.setParameter("name", name);
        return  query.getResultList().toString();
    }




}
