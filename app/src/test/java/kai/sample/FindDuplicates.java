package kai.sample;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by yongkai.teo on 28/8/17.
 */

public class FindDuplicates {
    @Test
    public void test() throws Exception {
        System.out.println(findDupSetSolution(new int[]{1, 2, 3, 1, 2}));
        System.out.println(findDupEncoded(new int[]{1, 2, 3, 1, 2}));
    }

    List<Integer> findDupSetSolution(int[] arr) {
        final ArrayList<Integer> list = new ArrayList<>();
        final HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(i)) {
                list.add(i);
            } else {
                set.add(i);
            }
        }

        return list;
    }

    List<Integer> findDupEncoded(int[] arr) {
        final HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;
            if (arr[index] < 0) {
                set.add(Math.abs(arr[index]));
            } else {
                arr[index] = -arr[index];
            }
        }

        return new ArrayList<>(set);
    }
}
