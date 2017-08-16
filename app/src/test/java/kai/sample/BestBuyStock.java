package kai.sample;

import org.junit.Test;

/**
 * Created by yongkai.teo on 8/8/17.
 */

public class BestBuyStock {
    @Test
    public void test() {
        System.out.println(maxProfit(new int[]{2, 5, 7, 1, 4, 3, 1, 3}, 3));
    }

    public int maxProfit(int[] price, int transaction) {
        int[][] result = new int[price.length][transaction + 1];
        for (int i = 1; i <= transaction; i++) {
            int maxDiff = -price[0];
            for (int j = 1; j < price.length; j++) {
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

        return result[2][3];
    }
}
