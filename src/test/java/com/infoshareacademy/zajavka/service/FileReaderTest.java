package com.infoshareacademy.zajavka.service;

import com.infoshareacademy.zajavka.data.Currency;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Class for unit testing data aquiring methods")
class FileReaderTest {

    @Test
    @DisplayName("Should return empty list on empty list given")
    void readFileWhenIsOneCorrectFile() {
        // given
        FileReader subject = new FileReader();
        List<String> testList = new LinkedList<>();
        List<Currency> expected = new LinkedList<>();

        // when
        List<Currency> actual = subject.getCurrencyDataListFromfiles("", testList);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should return one currency read from the inout")
    void dsadsadsdasdas() {
        // given
        FileReader subject = new FileReader();
        List<String> testList = Arrays.asList("", "");
        List<Currency> expected = Arrays.asList( );

        // when
        List<Currency> actual = subject.getCurrencyDataListFromfiles("", testList);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testFile() {
        String path = FileReaderTest.class.getResource("/test_data1").getPath();
        System.out.println(path);
    }


}