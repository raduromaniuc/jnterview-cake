import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestAppleStocks {

    /**
     * Randomly generates int arrays and computes all
     * possible combinations to get the right answer.
     * */
    @Test
    public void testRandomStockPrices() {
        int listSize = 10;
        int noPrices = 10;

        List<int[]> stockPricesList = getListOfStockPrices(listSize, noPrices);

        System.out.println("Tested arrays:");
        stockPricesList.forEach(stockPrices -> {
            System.out.println(Arrays.toString(stockPrices));

            Assert.assertEquals("Invalid max profit computation.",
                    AppleStocks.getMaxProfit(stockPrices),
                    getActualMaxProfit(stockPrices)
            );
        });
    }

    private List<int[]> getListOfStockPrices(int listSize, int noPrices) {
        List<int[]> list = new ArrayList<>();

        for(int i = 0; i < listSize; i++) {
            list.add(getRandomIntArray(noPrices));
        }

        return list;
    }

    private int[] getRandomIntArray(int arrayLength) {
        if(arrayLength <= 0) {
            throw new IllegalArgumentException("Invalid array length.");
        }

        int[] arr = new int[arrayLength];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        return arr;
    }

    /**
     * Slowly, but correctly computes the max profit,
     * given a list of stock prices. Simply computes
     * all the possible profits and selects the
     * highest one.
     *
     * O(n^2) execution time
     * O(1) memory consumption
     * */
    private int getActualMaxProfit(int[] stockPrices) {
        int maxProfit = 0;
        for(int i = 0; i < stockPrices.length; i++) {
            for(int j = i + 1, currentProfit; j < stockPrices.length; j++) {
                currentProfit = stockPrices[j] - stockPrices[i];

                if(currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                }
            }
        }

        return maxProfit;
    }
}
