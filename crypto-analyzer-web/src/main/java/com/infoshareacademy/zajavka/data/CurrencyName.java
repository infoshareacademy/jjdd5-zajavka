package com.infoshareacademy.zajavka.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CURRENCY_NAMES")
public class CurrencyName {

    @Id
    @Column(name = "NAME_FILE", length = 60)
    @NotNull
    private String nameFile;

    @Column(name = "NAME_CURRENCY")
    @NotNull
    private String nameCurrency;

    public CurrencyName() {
    }

    public CurrencyName(@NotNull String nameFile, @NotNull String nameCurrency) {
        this.nameFile = nameFile;
        this.nameCurrency = nameCurrency;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public String getNameCurrency() {
        return nameCurrency;
    }

    public void setNameCurrency(String nameCurrency) {
        this.nameCurrency = nameCurrency;
    }
}
