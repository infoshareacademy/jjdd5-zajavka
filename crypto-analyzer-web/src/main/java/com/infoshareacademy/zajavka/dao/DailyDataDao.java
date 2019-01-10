package com.infoshareacademy.zajavka.dao;

import com.infoshareacademy.zajavka.data.Chart;
import com.infoshareacademy.zajavka.data.Currency;
import com.infoshareacademy.zajavka.data.DailyData;
import com.infoshareacademy.zajavka.service.UploadService;
import org.hibernate.query.QueryProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class DailyDataDao {

    private static final Logger LOG = LoggerFactory.getLogger(DailyDataDao.class);

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

    public List<DailyData> findByCurrency(String currency) {
        Query query = entityManager
                .createQuery("SELECT s FROM DailyData s WHERE s.currency.name = :name ORDER BY s.date DESC");
        query.setParameter("name", currency);
        return query.getResultList();
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

    public Chart getDataChartForTimeRange(String currencyName, LocalDate startDate, LocalDate endDate) {
        Chart retChart = new Chart();
        final Query query = entityManager
                .createQuery("SELECT s FROM DailyData s WHERE s.currency.name = :currency AND s.date > :startDate AND s.date < :endDate ORDER BY s.date DESC");
        query.setParameter("currency", currencyName);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        List<DailyData> dd = query.setMaxResults(100).getResultList();
        retChart.setDatesStr(dd.stream().map(d -> d.getDate().toString()).collect(Collectors.toList()));
        retChart.setPricesStr(returnListStringOfPrices(dd));
        return  retChart;
    }

    public Chart getDataChartForCurrency(String currencyName) {
        Chart retChart = new Chart();
        final Query query = entityManager
                .createQuery("SELECT s FROM DailyData s WHERE s.currency.name = :currency ORDER BY s.date DESC");
        query.setParameter("currency", currencyName);
        List<DailyData> dd = query.setMaxResults(100).getResultList();
        retChart.setDatesStr(dd.stream().map(d -> d.getDate().toString()).collect(Collectors.toList()));
        retChart.setPricesStr(returnListStringOfPrices(dd));
        return  retChart;
    }

    private String returnListStringOfPrices(List<DailyData> dd){
        String retStr= new String();
        for (int i=0 ; i< dd.size() ; i++){
            retStr += dd.get(i).getStrPriceUSD();
            if (i< dd.size()-1) {
                retStr+= ", ";
            }
        }
        return retStr;
    }

    public List<LocalDate> getListDatesWithPrices(String currency){
        List<DailyData> list = findByCurrency(currency);
        return list.stream()
                .sorted(Comparator.comparing(DailyData::getDate))
                .filter(d ->d.getPriceUSD().compareTo(BigDecimal.ZERO) > 0)
                .map(DailyData::getDate)
                .collect(Collectors.toList());
    }

    public LocalDate getFirstDayWithPrice(List<LocalDate> list){
        return list.get(0);
    }

    public LocalDate getLastDayWithPrice(List<LocalDate> list){
        return list.get(list.size() - 1);
    }

    public boolean isDateCorrect(String date, String currencyName){
        LocalDate parsedDate = LocalDate.parse(date);

        try {
            final Query query = entityManager
                    .createQuery("SELECT s FROM DailyData s WHERE s.date = :date AND s.currency.name = :currency");
            query.setParameter("date", date);
            query.setParameter("currency", currencyName);
            return true;
        }
        catch (NoResultException e){
            LOG.warn("Date has not been found in the data base" + e.getMessage());
            return false;
        }
    }

    public boolean isDateWithPrice(String date, List<LocalDate> list){ return ((date != null) && (list.contains(LocalDate.parse(date))));
    }

}
