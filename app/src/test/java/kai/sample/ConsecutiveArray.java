package kai.sample;

import org.junit.Test;

import java.util.HashSet;

/**
 * Created by yongkai.teo on 29/8/17.
 */

public class ConsecutiveArray {
    @Test
    public void test() throws Exception {
        System.out.println(getConsecutive(new int[]{1, 2, 4, 5, 6}));
    }

    int getConsecutive(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }

        int max = 0;
        for (int i : set) {
            if (set.contains(i - 1)) {
                continue;
            }

            int count = 0;
            while (set.contains(i++)) {
                count++;
            }
            max = Math.max(max, count);
        }

        return max;
    }
}
