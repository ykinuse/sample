package kai.sample;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by ykinuse on 18/8/17.
 */

public class IntPremutation {
    @Test
    public void test() throws Exception {
        int count = 0;
        long time = System.currentTimeMillis();
        for (int[] array : premutation(new int[]{1, 2, 3, 4, 5, 1, 2, 1})) {
            count++;
        }
        System.out.println(count + " " + (System.currentTimeMillis() - time));
    }

    public ArrayList<int[]> premutation(int[] input) {
        ArrayList<int[]> list = new ArrayList<>();
        permutate(input, 0, list);
        return list;
    }

    void permutate(int[] input, int index, ArrayList<int[]> list) {
        if (index == input.length) {
            list.add(input.clone());
            return;
        }

        for (int i = index; i < input.length; i++) {
            swap(input, i, index);
            permutate(input, index + 1, list);
            swap(input, i, index);
        }
    }

    void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
