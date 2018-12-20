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
    @Column(name = "NAME_FILE", length = 60, unique = true)
    @NotNull
    private String nameFile;

    @Column(name = "NAME_CURRENCY")
    @NotNull
    private String nameCurrency;

    @Column(name = "PROMOTING")
    @NotNull
    private Boolean promoting;

    public CurrencyName() {
    }

    public CurrencyName(@NotNull String nameFile, @NotNull String nameCurrency, @NotNull Boolean promoting) {
        this.nameFile = nameFile;
        this.nameCurrency = nameCurrency;
        this.promoting = promoting;
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

    public Boolean getPromoting() {
        return promoting;
    }

    public void setPromoting(Boolean promoting) {
        this.promoting = promoting;
    }
}
