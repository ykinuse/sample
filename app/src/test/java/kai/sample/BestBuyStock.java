package kai.sample;

import org.junit.Test;

/**
 * Created by yongkai.teo on 8/8/17.
 */

public class BestBuyStock {
    int count;
    int count2;

    @Test
    public void test() {
        int[] arr = new int[]{2, 5, 7, 1, 4, 3, 1, 3, 5, 100, 20, 50, 10};
        int transaction = 4;
        System.out.println(maxProfit(arr, transaction));
        System.out.println("Loop " + count2);

        Integer[][] cache = new Integer[transaction + 1][arr.length];
        System.out.println(maxProfitDP(arr, transaction, 0, 0, 0, cache));
        System.out.println("Recurr " + count);
    }

    int maxProfitDP(int[] price, int transaction, int index, int lastPrice, int lastPriceIndex, Integer[][] cache) {
        count++;
        if (index >= price.length || transaction <= 0) {
            return 0;
        }

        if (cache[transaction][lastPriceIndex] != null) {
            return cache[transaction][lastPriceIndex];
        }

        if (lastPrice == 0) {
            int ifDontBuy = maxProfitDP(price, transaction, index + 1, lastPrice, lastPriceIndex, cache);
            int ifBuy = maxProfitDP(price, transaction, index + 1, price[index], index, cache);
            int result = Math.max(ifDontBuy, ifBuy);
            if (result == ifBuy) {
                cache[transaction][index] = result;
            }
            return result;
        } else {
            if (lastPrice >= price[index]) {
                int result = maxProfitDP(price, transaction, index + 1, lastPrice, lastPriceIndex, cache);
                cache[transaction][lastPriceIndex] = result;
                return result;
            }

            int ifDontSell = maxProfitDP(price, transaction, index + 1, lastPrice, lastPriceIndex, cache);
            int ifSell = price[index] - lastPrice + maxProfitDP(price, transaction - 1, index + 1, 0, 0, cache);
            int result = Math.max(ifDontSell, ifSell);

            cache[transaction][lastPriceIndex] = result;
            return result;
        }

    }

    public int maxProfit(int[] price, int transaction) {
        int[][] result = new int[price.length][transaction + 1];
        for (int i = 1; i <= transaction; i++) {
            int maxDiff = -price[0];
            for (int j = 1; j < price.length; j++) {
                count2++;
                result[j][i] = Math.max(price[j] + maxDiff, result[j - 1][i]);
                maxDiff = Math.max(maxDiff, result[j][i - 1] - price[j]);
            }
        }
//        for (int i = 0; i < price.length; i++) {
//            for (int j = 0; j <= transaction; j++) {
//                if (i == 0 || j == 0) {
//                    result[i][j] = 0;
//                } else {
//                    int bestPrice = result[i - 1][j];
//                    for (int k = 0; k < i; k++) {
//                        bestPrice = Math.max(bestPrice, (price[i] - price[k]) + result[k][j - 1]);
//                    }
//                    result[i][j] = bestPrice;
//                }
//            }
//        }

        return result[result.length - 1][result[result.length - 1].length - 1];
    }
}
