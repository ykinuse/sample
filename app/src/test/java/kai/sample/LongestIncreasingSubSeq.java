package kai.sample;

import org.junit.Test;

/**
 * Created by yongkai.teo on 14/8/17.
 */

public class LongestIncreasingSubSeq {
    @Test
    public void test() {
        System.out.println(longestIncreasingSubSeq(new int[]{1, 2, 4, -1, 5, 0, 6, 3, 6}));
    }

    public int longestIncreasingSubSeq(int[] array) {
        int[] cached = new int[array.length];
        cached[0] = 1;
        int max = 0;
        int i = 1;
        while (i < array.length) {
            int j = 0;
            while (j < i) {
                if (array[j] < array[i]) {
                    cached[i] = Math.max(cached[j] + 1, cached[i]);
                }
                j++;
            }
            max = Math.max(max, cached[i]);
            i++;
        }

        return max;
    }
}
