package kai.sample;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by ykinuse on 19/8/17.
 */

public class MergeArray {
    @Test
    public void test() throws Exception {
        System.out.println(Arrays.toString(merge(new int[]{1, 3, 5, 0, 0, 0, 0}, new int[]{ 4, 6, 8,8})));
    }

    int[] merge(int[] dest, int[] arr) {
        int i = 0;
        int j = 0;
        while (i < dest.length && j < arr.length) {
            int destValue = dest[i];
            int arrValue = arr[j];
            if (destValue == 0) {
                dest[i] = arrValue;
                j++;
            } else if (destValue > arrValue) {
                dest[i] = arr[j];
                arr[j] = destValue;
            }
            i++;
        }

        return dest;
    }
}
