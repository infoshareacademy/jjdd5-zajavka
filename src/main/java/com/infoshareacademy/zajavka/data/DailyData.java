package com.infoshareacademy.zajavka.data;

import com.infoshareacademy.zajavka.configuration.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.infoshareacademy.zajavka.configuration.ReadConfiguration.loadProperties;

public class DailyData {
    private LocalDate date;
    private BigDecimal txVolumeUSD;
    private BigDecimal adjTxVolumeUSD;
    private BigDecimal txCount;
    private BigDecimal marcetCapUSD;
    private BigDecimal priceUSD;
    private BigDecimal exVolumeUSD;
    private BigDecimal generatedCoins;
    private BigDecimal fees;
    private BigDecimal activeAdresess;
    private BigDecimal averageDifficulty;
    private BigDecimal paymentCount;
    private BigDecimal medianTxValueUSD;
    private BigDecimal medianFee;
    private BigDecimal blockSize;
    private BigDecimal blockCount;
    Configuration configuration = loadProperties();

    public DailyData(LocalDate date, BigDecimal txVolumeUSD, BigDecimal adjTxVolumeUSD, BigDecimal txCount, BigDecimal marcetCapUSD, BigDecimal priceUSD, BigDecimal exVolumeUSD, BigDecimal generatedCoins, BigDecimal fees, BigDecimal activeAdresess, BigDecimal averageDifficulty, BigDecimal paymentCount, BigDecimal medianTxValueUSD, BigDecimal medianFee, BigDecimal blockSize, BigDecimal blockCount) {
        this.date = date;
        this.txVolumeUSD = txVolumeUSD;
        this.adjTxVolumeUSD = adjTxVolumeUSD;
        this.txCount = txCount;
        this.marcetCapUSD = marcetCapUSD;
        this.priceUSD = priceUSD;
        this.exVolumeUSD = exVolumeUSD;
        this.generatedCoins = generatedCoins;
        this.fees = fees;
        this.activeAdresess = activeAdresess;
        this.averageDifficulty = averageDifficulty;
        this.paymentCount = paymentCount;
        this.medianTxValueUSD = medianTxValueUSD;
        this.medianFee = medianFee;
        this.blockSize = blockSize;
        this.blockCount = blockCount;
    }

    public DailyData() {
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTxVolumeUSD(BigDecimal txVolumeUSD) {
        this.txVolumeUSD = txVolumeUSD;
    }

    public void setAdjTxVolumeUSD(BigDecimal adjTxVolumeUSD) {
        this.adjTxVolumeUSD = adjTxVolumeUSD;
    }

    public void setTxCount(BigDecimal txCount) {
        this.txCount = txCount;
    }

    public void setMarcetCapUSD(BigDecimal marcetCapUSD) {
        this.marcetCapUSD = marcetCapUSD;
    }

    public void setPriceUSD(BigDecimal priceUSD) {
        this.priceUSD = priceUSD;
    }

    public void setExVolumeUSD(BigDecimal exVolumeUSD) {
        this.exVolumeUSD = exVolumeUSD;
    }

    public void setGeneratedCoins(BigDecimal generatedCoins) {
        this.generatedCoins = generatedCoins;
    }

    public void setFees(BigDecimal fees) {
        this.fees = fees;
    }

    public void setActiveAdresess(BigDecimal activeAdresess) {
        this.activeAdresess = activeAdresess;
    }

    public void setAverageDifficulty(BigDecimal averageDifficulty) {
        this.averageDifficulty = averageDifficulty;
    }

    public void setPaymentCount(BigDecimal paymentCount) {
        this.paymentCount = paymentCount;
    }

    public void setMedianTxValueUSD(BigDecimal medianTxValueUSD) {
        this.medianTxValueUSD = medianTxValueUSD;
    }

    public void setMedianFee(BigDecimal medianFee) {
        this.medianFee = medianFee;
    }

    public void setBlockSize(BigDecimal blockSize) {
        this.blockSize = blockSize;
    }

    public void setBlockCount(BigDecimal blockCount) {
        this.blockCount = blockCount;
    }

    public LocalDate Date() {
        return date;
    }

    public LocalDate getDate() {
        return date;
    }

    public BigDecimal TxVolumeUSD() {
        return txVolumeUSD;
    }

    public BigDecimal AdjTxVolumeUSD() {
        return adjTxVolumeUSD;
    }

    public BigDecimal getTxCount() {
        return txCount;
    }

    public BigDecimal MarcetCapUSD() {
        return marcetCapUSD;
    }

    public BigDecimal PriceUSD() {
        return priceUSD;
    }

    public BigDecimal getPriceUSD() {
        return priceUSD;
    }

    public BigDecimal ExVolumeUSD() {
        return exVolumeUSD;
    }

    public BigDecimal GeneratedCoins() {
        return generatedCoins;
    }

    public BigDecimal Fees() {
        return fees;
    }

    public BigDecimal ActiveAdresess() {
        return activeAdresess;
    }

    public BigDecimal AverageDifficulty() {
        return averageDifficulty;
    }

    public BigDecimal PaymentCount() {
        return paymentCount;
    }

    public BigDecimal MedianTxValueUSD() {
        return medianTxValueUSD;
    }

    public BigDecimal MedianFee() {
        return medianFee;
    }

    public BigDecimal BlockSize() {
        return blockSize;
    }

    public BigDecimal BlockCount() {
        return blockCount;
    }

    @Override
    public String toString() {
        return "DailyData{" +
                " date = " + date.format(configuration.getDateFormat()) + " " + configuration.getCharForSeparate() +
                " txVolumeUSD = " + txVolumeUSD.setScale(configuration.getAmountNumberAfterSign(), BigDecimal.ROUND_HALF_DOWN) + " " + configuration.getCharForSeparate() +
                " adjTxVolumeUSD = " + adjTxVolumeUSD.setScale(configuration.getAmountNumberAfterSign(), BigDecimal.ROUND_HALF_DOWN) + " " + configuration.getCharForSeparate() +
                " txCount = " + txCount.setScale(configuration.getAmountNumberAfterSign(), BigDecimal.ROUND_HALF_DOWN) + " " + configuration.getCharForSeparate() +
                " marcetCapUSD = " + marcetCapUSD.setScale(configuration.getAmountNumberAfterSign(), BigDecimal.ROUND_HALF_DOWN) + " " + configuration.getCharForSeparate() +
                " priceUSD = " + priceUSD.setScale(configuration.getAmountNumberAfterSign(), BigDecimal.ROUND_HALF_DOWN) + " " + configuration.getCharForSeparate() +
                " exVolumeUSD = " + exVolumeUSD.setScale(configuration.getAmountNumberAfterSign(), BigDecimal.ROUND_HALF_DOWN) + " " + configuration.getCharForSeparate() +
                " generatedCoins = " + generatedCoins.setScale(configuration.getAmountNumberAfterSign(), BigDecimal.ROUND_HALF_DOWN) + " " + configuration.getCharForSeparate() +
                " fees = " + fees.setScale(configuration.getAmountNumberAfterSign(), BigDecimal.ROUND_HALF_DOWN) + " " + configuration.getCharForSeparate() +
                " activeAdresess = " + activeAdresess.setScale(configuration.getAmountNumberAfterSign(), BigDecimal.ROUND_HALF_DOWN) + " " + configuration.getCharForSeparate() +
                " averageDifficulty = " + averageDifficulty.setScale(configuration.getAmountNumberAfterSign(), BigDecimal.ROUND_HALF_DOWN) + " " + configuration.getCharForSeparate() +
                " paymentCount = " + paymentCount.setScale(configuration.getAmountNumberAfterSign(), BigDecimal.ROUND_HALF_DOWN) + " " + configuration.getCharForSeparate() +
                " medianTxValueUSD = " + medianTxValueUSD.setScale(configuration.getAmountNumberAfterSign(), BigDecimal.ROUND_HALF_DOWN) + " " + configuration.getCharForSeparate() +
                " medianFee = " + medianFee.setScale(configuration.getAmountNumberAfterSign(), BigDecimal.ROUND_HALF_DOWN) + " " + configuration.getCharForSeparate() +
                " blockSize = " + blockSize.setScale(configuration.getAmountNumberAfterSign(), BigDecimal.ROUND_HALF_DOWN) + " " + configuration.getCharForSeparate() +
                " blockCount = " + blockCount.setScale(configuration.getAmountNumberAfterSign(), BigDecimal.ROUND_HALF_DOWN) + " " + configuration.getCharForSeparate() +
                '}';
    }
}
