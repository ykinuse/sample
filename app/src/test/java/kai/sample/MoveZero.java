package kai.sample;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by yongkai.teo on 14/8/17.
 */

public class MoveZero {
    @Test
    public void test() {
        int[] value = new int[]{1, 0, 5, 0, 4, 2, 0, 0, 6};
        move(value);
        System.out.println(Arrays.toString(value));
    }

    public void move(int[] array) {
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            int left = array[i];
            int right = array[j];
            if (left == 0) {
                if (right != 0) {
                    exchange(array, i, j);
                    i++;
                    j--;
                } else {
                    j--;
                }
            } else {
                i++;
            }
        }
    }

    public void exchange(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
