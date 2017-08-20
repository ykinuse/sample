package kai.sample;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by ykinuse on 18/8/17.
 */

public class ThreeSum {
    @Test
    public void test() throws Exception {
        sum(new int[]{-1, 0, 1, 2, -1, -4});
    }

    void sum(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int remaining = 0 - (array[i] + array[j]);
                if (map.containsKey(remaining) && map.get(remaining) > j) {
                    System.out.println(array[i] + " " + array[j] + " " + array[map.get(remaining)]);
                }

            }
        }
    }

    void sumO1Space(int[] array) {
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            int j = i + 1;
            int k = array.length-1;
            while (j < k) {
                if (array[i] + array[j] + array[k] == 0) {
                    System.out.println(array[i] + " " + array[j] + " " + array[k]);
                    j++;
                    k--;
                } else {
                    if (array[j] + array[k] > array[i]) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }
    }
}
