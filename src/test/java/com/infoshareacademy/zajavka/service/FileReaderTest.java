package com.infoshareacademy.zajavka.service;

import com.infoshareacademy.zajavka.data.Currency;
import com.infoshareacademy.zajavka.data.DailyData;
import com.infoshareacademy.zajavka.data.ListDirectoryException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Class for unit testing data aquiring methods")
class FileReaderTest {

    @Test
    @DisplayName("Should return empty object when is only empty file in directory")
    void shouldReturnEmptyObjectWhenIsOnlyEmptyFileInDirectory() {
        // given
        FileReader subject = new FileReader();
        String path = FileReaderTest.class.getResource("/test_data1").getPath();
        System.out.println(path +" - path to file");
        List<Currency> currencyList = new ArrayList<>();
        List<Currency> emptyList = new ArrayList<>();

        //when
        try {
            currencyList = subject.getCurrenciesFromDirectory(path);
        } catch (ListDirectoryException e) {
            System.out.println("exception");
        }

        //then
        assertThat(currencyList).isEqualTo(emptyList);
    }

    @Test
    @DisplayName("Should return empty object when is only empty file in directory")
    void shouldReturnCorectObjectWhenIsOneFileInDirectoryWithOneLine() {
        // given
        FileReader subject = new FileReader();
        String path = FileReaderTest.class.getResource("/test_data2").getPath();
        System.out.println(path +" - path to file");
        List<Currency> currencyList = new ArrayList<>();


        //when
        try {
            currencyList = subject.getCurrenciesFromDirectory(path);
        } catch (ListDirectoryException e) {
            System.out.println("exception");
        }

        //then
        assertThat(currencyList.size()).isEqualTo(1);
        assertThat(currencyList.get(0).getName()).isEqualTo("btc.csv");
        assertThat(currencyList.get(0).getDailyDataList().size()).isEqualTo(3);
        assertThat(currencyList.get(0).getDailyDataList().get(1).BlockSize()).isEqualTo(BigDecimal.valueOf(13129));

    }


}