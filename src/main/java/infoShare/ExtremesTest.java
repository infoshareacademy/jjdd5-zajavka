package infoShare;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class ExtremesTest {
    public static void main(String[] args) {


        List<DailyData> bitcoin = new ArrayList<>();

        System.out.println(maxPrice(bitcoin));
        System.out.println(minPrice(bitcoin));


    }
public List<DailyData>getPrices(){
        return Collection
}


    public static BigDecimal maxPrice(List<DailyData> bitcoin) {
        return bitcoin.stream()
                .max(Comparator.comparing(DailyData::getPriceUSD))
                .get().getPriceUSD();
    }

    public static BigDecimal minPrice (List<DailyData>bitcoin){
        return bitcoin.stream()
                .min(Comparator.comparing(DailyData::getPriceUSD))
                .get().getTxCount();
}


}

