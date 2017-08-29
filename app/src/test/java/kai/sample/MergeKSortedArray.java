package kai.sample;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by yongkai.teo on 29/8/17.
 */

public class MergeKSortedArray {
    @Test
    public void test() throws Exception {
        System.out.println(Arrays.toString(mergeKSortedArray(new int[][]{new int[]{1, 4, 7}, new int[]{2, 5, 8}, new int[]{3, 6, 9}})));
    }

    private Integer[] mergeKSortedArray(int[][] arr) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int[] arr2 : arr) {
            for (int i : arr2) {
                set.add(i);
            }
        }

        return new ArrayList<>(set).toArray(new Integer[set.size()]);
    }
}
