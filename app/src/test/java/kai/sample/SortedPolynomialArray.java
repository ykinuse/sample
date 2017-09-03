package kai.sample;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by ykinuse on 3/9/17.
 */

public class SortedPolynomialArray {
    @Test
    public void test() throws Exception {
        System.out.println(Arrays.toString(sorted(new int[]{1, 2, 3, 4, 5}, -6, -7, 2)));
    }

    int[] sorted(int[] arr, int a, int b, int c) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] * a * a) + (arr[i] * b) + c;
        }

        return arr;
    }
}
