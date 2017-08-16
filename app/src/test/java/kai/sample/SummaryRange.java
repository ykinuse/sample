package kai.sample;

import org.junit.Test;

/**
 * Created by yongkai.teo on 10/8/17.
 */

public class SummaryRange {

    @Test
    public void test() {
        int[] value = new int[]{0, 1, 2, 4, 5, 7};
        System.out.println(getSummaryRange(value));
    }

    public String getSummaryRange(int[] arrays) {
        String result = String.valueOf(arrays[0]);
        int value = arrays[0];
        boolean start = true;
        for (int i = 1; i < arrays.length; i++) {
            if (arrays[i] != value + 1) {
                result += value;
                result += " ";
                result += arrays[i];
                start = true;
            } else {
                if (start) {
                    result += "->";
                    start = false;
                }
            }
            value = arrays[i];
        }
        return result;
    }
}
