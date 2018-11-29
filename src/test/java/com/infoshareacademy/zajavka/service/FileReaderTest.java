package com.infoshareacademy.zajavka.service;
import com.infoshareacademy.zajavka.data.Currency;
import com.infoshareacademy.zajavka.data.ListDirectoryException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
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
    @DisplayName("Should return correct list with one objectc when is one correct data")
    void shouldReturnCorectListWithOneObjectWhenIsOneFileInDirectoryWithCorrectData() {
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
        assertThat(currencyList.get(0).getDailyDataList().get(2).Date()).isEqualTo(LocalDate.parse("2009-01-11"));

    }

    @Test
    @DisplayName("Should return correct list with one objectc when is one correct data")
    void shouldReturnCorectListWithOTwoObjectWhenIsTwoFileInDirectoryWithCorrectData() {
        // given
        FileReader subject = new FileReader();
        String path = FileReaderTest.class.getResource("/test_data3").getPath();
        System.out.println(path +" - path to file");
        List<Currency> currencyList = new ArrayList<>();


        //when
        try {
            currencyList = subject.getCurrenciesFromDirectory(path);
        } catch (ListDirectoryException e) {
            System.out.println("exception");
        }

        //then
        assertThat(currencyList.size()).isEqualTo(2);
        assertThat(currencyList.get(0).getName()).isEqualTo("btc.csv");
        assertThat(currencyList.get(1).getName()).isEqualTo("ltc.csv");
        assertThat(currencyList.get(0).getDailyDataList().size()).isEqualTo(3);
        assertThat(currencyList.get(0).getDailyDataList().size()).isEqualTo(3);
        assertThat(currencyList.get(0).getDailyDataList().get(1).BlockSize()).isEqualTo(BigDecimal.valueOf(13129));
        assertThat(currencyList.get(0).getDailyDataList().get(2).Date()).isEqualTo(LocalDate.parse("2009-01-11"));
        assertThat(currencyList.get(1).getDailyDataList().get(1).BlockSize()).isEqualTo(BigDecimal.valueOf(790725));
        assertThat(currencyList.get(1).getDailyDataList().get(2).Date()).isEqualTo(LocalDate.parse("2011-10-22"));

    }

    @Test
    @DisplayName("Should return object with empty Places when data is wrong in corect file")
    void shouldReturnObjectWithEmptyPlacesWhenDataIsWrongInCorrectDirectory() {
        // given
        FileReader subject = new FileReader();
        String path = FileReaderTest.class.getResource("/test_data4").getPath();
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
        assertThat(currencyList.get(0).getDailyDataList().get(1).BlockCount()).isNull();
        assertThat(currencyList.get(0).getDailyDataList().get(2).Date()).isNull();
    }

    @Test
    @DisplayName("Should return object with one less element when one line in file has not correct count of data")
    void shouldReturnObjectWithOneLessElementWhenOneLineInFileHasNotCorrectCountOfData() {
        // given
        FileReader subject = new FileReader();
        String path = FileReaderTest.class.getResource("/test_data5").getPath();
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
        assertThat(currencyList.get(0).getDailyDataList().size()).isEqualTo(2);
        assertThat(currencyList.get(0).getDailyDataList().get(0).BlockSize()).isEqualTo(BigDecimal.valueOf(13129));
        assertThat(currencyList.get(0).getDailyDataList().get(1).Date()).isEqualTo(LocalDate.parse("2009-01-11"));
    }

    @Test
    @DisplayName("Should return empty object when is only wrong type file in directory")
    void shouldReturnEmptyObjectWhenIsOnlyWrongTypeFileInDirectory() {
        // given
        FileReader subject = new FileReader();
        String path = FileReaderTest.class.getResource("/test_data6").getPath();
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


}