package kai.sample;

import org.junit.Test;

/**
 * Created by yongkai.teo on 21/8/17.
 */

public class LongestConsecutiveString {
    @Test
    public void test() throws Exception {
        System.out.println(lcs("AABCDDBBBEA"));
    }

    String lcs(String text) {
        int currMax = 1;
        int max = 1;
        String lcs = "" + text.charAt(0);
        String currString = lcs;
        for (int i = 1; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == text.charAt(i - 1)) {
                currString += c;
                max++;
            } else {
                if (currMax < max) {
                    currMax = max;
                    lcs = currString;
                }

                max = 1;
                currString = "" + c;
            }
        }

        return lcs;

    }
}
