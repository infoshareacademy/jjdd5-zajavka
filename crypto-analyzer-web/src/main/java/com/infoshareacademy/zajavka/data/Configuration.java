package com.infoshareacademy.zajavka.data;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CONFIGURATIONS")
public class Configuration {

    @Id
    @Column(name = "NAME", length = 60)
    @NotNull
    private String name;

    @Column(name = "VALUE")
    @NotNull
    private String value;

    public Configuration() {
    }

    public Configuration(@NotNull String name, @NotNull String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
