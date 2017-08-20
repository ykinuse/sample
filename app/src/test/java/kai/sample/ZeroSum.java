package kai.sample;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by ykinuse on 19/8/17.
 */

public class ZeroSum {
    @Test
    public void test() throws Exception {
        System.out.println(Arrays.toString(zeroSum(new int[]{1, 2, -5, 1, 2, -1})));
        // 1 2 -5 1 2 -1
        // 0 1 3 -2 -1 1 0

        // 1 0 -5 1 2 -1
        // 0 1 1
    }

    int[] zeroSum(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i <= array.length; i++) {
            Integer oldIndex = map.get(sum);
            if (oldIndex == null && array.length == i) {
                return null;
            } else if (oldIndex == null) {
                map.put(sum, i);
                sum += array[i];
            } else {
                return Arrays.copyOfRange(array, oldIndex, i);
            }
        }

        return null;
    }
}
