package kai.sample;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by yongkai.teo on 11/8/17.
 */

public class ReverseString {
    @Test
    public void test() {
        char[] input = new char[]{'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'};
        System.out.println(Arrays.toString(input));
        input = reverse(input);
        System.out.println(Arrays.toString(input));
    }

    public char[] reverse(char[] arrays) {
        char[] reveresed = new char[arrays.length];
        int index = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == ' ') {
                System.arraycopy(arrays, index, reveresed, reveresed.length - i, i - index);
                reveresed[reveresed.length - i - 1] = arrays[i];
                index = i + 1;
            }
        }

        System.arraycopy(arrays, index, reveresed, 0, reveresed.length - index);

        return reveresed;
    }
}
