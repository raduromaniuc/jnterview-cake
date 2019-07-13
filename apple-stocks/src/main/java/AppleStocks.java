public class AppleStocks {

    public static void main(String[] args) {

        int[] stockPrices = new int[] {10, 7, 5, 8, 11, 9};

        System.out.println(getMaxProfit(stockPrices));

    }

    /**
     * O(n) execution time
     * O(1) memory consumption
     * */
    public static int getMaxProfit(int[] stockPrices) {
        if(stockPrices.length < 2) {
            throw new IllegalArgumentException("Expecting an int array with at least two values.");
        }

        int maxProfit = 0;
        int minPrice = stockPrices[0];


        for(int i = 1, currentProfit; i < stockPrices.length; i++) {
            currentProfit = stockPrices[i] - minPrice;

            if(currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }

            if(stockPrices[i] < minPrice) {
                minPrice = stockPrices[i];
            }
        }

        return maxProfit;
    }
}
