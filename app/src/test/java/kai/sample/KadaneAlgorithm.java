package kai.sample;

import org.junit.Test;

/**
 * Created by yongkai.teo on 29/8/17.
 */

public class KadaneAlgorithm {
    @Test
    public void test() throws Exception {
        System.out.println(maxSumSubArray(new int[]{1, 0, -3, 2, 5, -1, -8, 8, 0, -1, 1}));
    }

    int maxSumSubArray(int[] arr) {
        int currMax = arr[0] + arr[1];
        int max = currMax;
        for (int i = 2; i < arr.length; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            max = Math.max(currMax, max);
        }

        return max;
    }
}
