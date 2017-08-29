package kai.sample;

import org.junit.Test;

/**
 * Created by yongkai.teo on 28/8/17.
 */

public class SwapVariables {
    @Test
    public void test() throws Exception {
        int a = 988;
        int b = 1021;

//        a = a - b; // 30
//        b = b + a; // 40
//        a = b - a;
        System.out.println(String.valueOf((char) ('a' ^ 'b')));
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;


        System.out.println(a + " " + b);
    }
}
