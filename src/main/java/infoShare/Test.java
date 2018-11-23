package infoShare;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Path dataFilePath = Paths.get("src", "main","resources");
        List <String> fileNames = new ArrayList<>();
        List <Currency> currencyList = new ArrayList<>();
        LocalDate cDate;


        fileNames= FileReader.listFilesForFolder(dataFilePath);

        for (int i = 0; i < fileNames.size(); i++) {
            currencyList.add(new Currency(fileNames.get(i)));

            Path filePathWithName = Paths.get("src", "main","resources", fileNames.get(i));
            List<String> lines = FileReader.readFile(filePathWithName);// tworzy liste string kazdy jest linijka pliku

            for (int j = 1; j<lines.size(); j++) {
                currencyList.get(i).addDalyData(lines.get(j).split(","));//lies.get(j)wyciaga pojedyncza linijke
            }
        }


        for (Currency currency : currencyList) {
            System.out.println(currency.getName());
        }

        System.out.println(currencyList.get(1).maxPrice());
        System.out.println(currencyList.get(1).minPrice());

        while (true) {
            cDate = readDateFromConsole();
            for (Currency currency : currencyList) {
                System.out.println(currency.getName());
                System.out.println(currency.getDataForDate(cDate));
            }
        }

    }



    static LocalDate readDateFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj date w formacie: rrrr-mm-dd");
        return  LocalDate.parse(scanner.next());
    }
}
