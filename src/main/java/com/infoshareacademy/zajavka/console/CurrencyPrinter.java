package com.infoshareacademy.zajavka.console;
import com.infoshareacademy.zajavka.data.CurrencyComparator;
import com.infoshareacademy.zajavka.data.DailyData;


import java.util.List;
import java.util.Scanner;

public class CurrencyPrinter {

    public static void PrintNElementsfromCurrencyList(List<DailyData> dailyData, Integer listNumbers) {
        String key;
        Integer n = 0;
        do {
            dailyData.stream().sorted(new CurrencyComparator()).skip(n * listNumbers).limit(listNumbers).forEach(dd -> System.out.println(dd.Date() + " | " + dd.getPriceUSD() + " USD"));
            key = GetKey();
            n += key.equals("+") && n*listNumbers<=dailyData.size() ? 1 : 0;
            n -= key.equals("-") && n*listNumbers>=listNumbers ? 1 : 0;
        } while (!key.equals("b"));

    }

    public static String GetKey() {

        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

}
