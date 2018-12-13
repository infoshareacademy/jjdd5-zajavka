package com.infoshareacademy.zajavka.dao;

import com.infoshareacademy.zajavka.data.DailyData;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class DailyDataDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(DailyData s) {
        entityManager.persist(s);
    }

    public DailyData update(DailyData s) {
        return entityManager.merge(s);
    }


    public DailyData findByDate(LocalDate date) {
        return entityManager.find(DailyData.class, date);
    }

    public List<DailyData> findAll() {
        final Query query = entityManager.createQuery("SELECT s FROM DailyData s");

        return query.getResultList();
    }

    public List<DailyData> findDailyDataForDate(LocalDate date){
        final Query query = entityManager
                .createQuery("SELECT s FROM DailyData s WHERE s.date = :date");
        query.setParameter("date", date);
        return query.getResultList();
    }
}
