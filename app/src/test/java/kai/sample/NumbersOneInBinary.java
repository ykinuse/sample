package kai.sample;

import org.junit.Test;

/**
 * Created by yongkai.teo on 17/8/17.
 */

public class NumbersOneInBinary {
    @Test
    public void test() throws Exception {
        System.out.println(ones(7));
    }

    public int ones(int x) {
        // eg
        // 1 = 0b01
        // 2 = 0b10
        // 6 = 0b110
        // 7 = 0b111

        // Using x & 1 to eliminate all 1
        //       00000001
        // (AND) 10101010
        //       --------
        //       00000001

        System.out.println("shit1 " + (x << 1));
        System.out.println("shit2 " + (x >> 1));
        int sum = 0;
        while (x > 0) {
            sum += x & 1;
            x >>= 1;
        }

        return sum;
    }
}
