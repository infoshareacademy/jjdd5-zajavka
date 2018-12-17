package com.infoshareacademy.zajavka.dao;

import com.infoshareacademy.zajavka.data.Chart;
import com.infoshareacademy.zajavka.data.DailyData;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<DailyData> findDailyDataForDate(LocalDate date) {
        final Query query = entityManager
                .createQuery("SELECT s FROM DailyData s WHERE s.date = :date");
        query.setParameter("date", date);
        return query.getResultList();
    }

    public List<DailyData> getDataForCurrencyInDate(String currencyName, LocalDate date) {
        final Query query = entityManager
                .createQuery("SELECT s FROM DailyData s WHERE s.date = :date AND s.currency.name = :currency");
        query.setParameter("date", date);
        query.setParameter("currency", currencyName);
        return query.getResultList();
    }

    public DailyData getMostActualDataForCurrency(String currencyName) {
        final Query query = entityManager
                .createQuery("SELECT s FROM DailyData s WHERE s.currency.name = :currency ORDER BY s.date DESC");
        query.setParameter("currency", currencyName);
        return (DailyData) query.setMaxResults(1).getSingleResult();
    }

    public DailyData getPriceForSelectedDay(LocalDate date, String currencyName){
        final Query query = entityManager
                .createQuery("SELECT s FROM DailyData s WHERE s.date = :date AND s.currency.name = :currency");
        query.setParameter("date", date);
        query.setParameter("currency", currencyName);
        return (DailyData) query.getSingleResult();
    }

    public DailyData getGlobalMin(String currencyName){
        final Query query = entityManager
                .createQuery("SELECT s FROM DailyData s WHERE  s.currency.name = :currency ORDER BY s.priceUSD ASC ");
        query.setParameter("currency", currencyName);
        return (DailyData) query.setMaxResults(1).getSingleResult();
    }

    public DailyData getGlobalMax(String currencyName){
        final Query query = entityManager
                .createQuery("SELECT s FROM DailyData s WHERE  s.currency.name = :currency ORDER BY s.priceUSD DESC ");
        query.setParameter("currency", currencyName);
        return (DailyData) query.setMaxResults(1).getSingleResult();
    }

    public DailyData getLocalMax(String currencyName, LocalDate startDate, LocalDate endDate){
        final Query query = entityManager
                .createQuery("SELECT s FROM DailyData s WHERE  s.currency.name = :currency AND s.date > :startDate AND s.date < :endDate ORDER BY s.priceUSD DESC ");
        query.setParameter("currency", currencyName);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return (DailyData) query.setMaxResults(1).getSingleResult();
    }

    public DailyData getLocalMin(String currencyName, LocalDate startDate, LocalDate endDate){
        final Query query = entityManager
                .createQuery("SELECT s FROM DailyData s WHERE  s.currency.name = :currency AND s.date > :startDate AND s.date < :endDate ORDER BY s.priceUSD ASC ");
        query.setParameter("currency", currencyName);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return (DailyData) query.setMaxResults(1).getSingleResult();
    }

    public List<DailyData> getPricesInTimeRange(String currencyName, LocalDate startDate, LocalDate endDate){
        final Query query = entityManager
                .createQuery("SELECT s FROM DailyData s WHERE  s.currency.name = :currency AND s.date > :startDate AND s.date < :endDate ORDER BY s.date DESC ");
        query.setParameter("currency", currencyName);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query.getResultList();
    }


    public List<DailyData> getAllDailyDatasForCurrency(String currencyName) {
        final Query query = entityManager
                .createQuery("SELECT s FROM DailyData s WHERE s.currency.name = :currency ORDER BY s.date DESC");
        query.setParameter("currency", currencyName);
        return query.setMaxResults(100).getResultList();
    }

    public Chart getDataChartForCurrency(String currencyName) {
        Chart retChart = new Chart();
        final Query query = entityManager
                .createQuery("SELECT s FROM DailyData s WHERE s.currency.name = :currency ORDER BY s.date DESC");
        query.setParameter("currency", currencyName);
        List<DailyData> dd = query.setMaxResults(100).getResultList();
        retChart.setDatesStr(dd.stream().map(d -> d.getDate().toString()).collect(Collectors.toList()));
        retChart.setPricesStr(ReturnListStringOfPrices (dd));
        return  retChart;
    }
     private String ReturnListStringOfDates (List<DailyData> dd){
        String retStr= new String();
        for (int i=0 ; i< dd.size() ; i++){
            retStr += "\"" + dd.get(i).getDate().toString() + "\"";
            if (i< dd.size()-1) {
                retStr+= ", ";
            }
        }
        return retStr;
     }
    private String ReturnListStringOfPrices (List<DailyData> dd){
        String retStr= new String();
        for (int i=0 ; i< dd.size() ; i++){
            retStr += dd.get(i).getStrPriceUSD().toString();
            if (i< dd.size()-1) {
                retStr+= ", ";
            }
        }
        return retStr;
    }
}
